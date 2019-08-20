// Notes:
//  * Indentation is important in this file. Please, use 4 spaces for indent. *NO TABS*.

load PIPELINE_ROOT + "/modules/ChIPseq/normbigwig.vars.groovy"

normbigwig = {
    doc title: "normbigwig",
        desc:  "normbigwig wrapper",
        constraints: "Only performs treatment control substracted normlised bigwig tracks",
        bpipe_version: "tested with bpipe 0.9.8.7",
        author: "Nastasja Kreim"

    output.dir = NORMBIGWIG_OUTDIR 

    def TOOL_ENV = prepare_tool_env("R", tools["R"]["version"], tools["R"]["runenv"]) + " && " +
                   prepare_tool_env("deeptools", tools["deeptools"]["version"], tools["deeptools"]["runenv"])  + " && " +
                   prepare_tool_env("kentutils", tools["kentutils"]["version"], tools["kentutils"]["runenv"])  + " && " +
                   prepare_tool_env("samtools", tools["samtools"]["version"], tools["samtools"]["runenv"])
    def PREAMBLE = get_preamble("normbigwig")

    transform(".bam") to("_normbigwig.done") {
        exec """
            ${TOOL_ENV} &&
            ${PREAMBLE} &&

            if [ ! -e $NORMBIGWIG_TARGETS ]; then
                echo "Targets file $NORMBIGWIG_TARGETS doesn't exist" >> $output &&
                exit 0;
            fi;
            touch $output;
            BAM=\$(basename $input) &&
            grep \$BAM $NORMBIGWIG_TARGETS | while read -r TARGET; do
                IP=\$(       echo $TARGET | tr '\t' ' ' | cut -f1 -d" ") &&
                IPname=\$(   echo $TARGET | tr '\t' ' ' | cut -f2 -d" ") &&
                INPUT=\$(    echo $TARGET | tr '\t' ' ' | cut -f3 -d" ") &&
                INPUTname=\$(echo $TARGET | tr '\t' ' ' | cut -f4 -d" ");
                if [ "\$BAM" != "\$INPUT" ]; then
                    echo "\${IPname} vs \${INPUTname}" >> $output ;
                    CHRSIZES=\${TMP}/\$(basename ${input.prefix}).bam2bw.chrsizes &&
                    samtools idxstats ${input} | cut -f1-2 > \${CHRSIZES} &&
                    bamCompare -b1 $input -b2 $NORMBIGWIG_MAPPED/$INPUT --numberOfProcessors $NORMBIGWIG_THREADS $NORMBIGWIG_OTHER --outFileName \${TMP}/\${BAM%.bam}_\${INPUTname}_norm.bedgraph &&
                    sort -k1,1 -k2,2n  \${TMP}/\${BAM%.bam}_\${INPUTname}_norm.bedgraph > \${TMP}/\${BAM%.bam}_\${INPUTname}_norm.bedgraph.sorted && 
                    bedGraphToBigWig \${TMP}/\${BAM%.bam}_\${INPUTname}_norm.bedgraph.sorted $CHRSIZES  $output.dir/\${BAM%.bam}_\${INPUTname}_norm.bw;
                    if [ \$? -ne 0 ]; then rm $output; fi;
                fi;
            done
        ""","normbigwig"
    }
    forward input
}

