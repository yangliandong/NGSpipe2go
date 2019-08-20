// Notes:
//  * Indentation is important in this file. Please, use 4 spaces for indent. *NO TABS*.

load PIPELINE_ROOT + "/modules/RNAseq/subread2rnatypes.vars.groovy"

subread2rnatypes = {
    doc title: "subread2rnatypes",
        desc:  "Counting gene biotypes in features with featureCounts of the subread package",
        constraints: "Default: strand specific counting.",
        bpipe_version: "tested with bpipe 0.9.8.7",
        author: "Oliver Drechsel"

    output.dir  = RNATYPES_OUTDIR
    def RNATYPES_FLAGS = "-F GTF --donotsort " +
                         RNATYPES_GENESGTF + " " +
                         RNATYPES_FEATURE  + " " +
                         RNATYPES_ACCUMULATE + " " +
                         RNATYPES_CORES    + " " +
                         RNATYPES_EXTRA    + " "

    if(RNATYPES_PAIRED == "yes") {
        RNATYPES_FLAGS = "-p " + RNATYPES_FLAGS
    }

    // no|yes|reverse
    if(RNATYPES_STRANDED == "no") {
        RNATYPES_FLAGS = "-s 0 " + RNATYPES_FLAGS
    }
    else if (RNATYPES_STRANDED == "yes") {
        RNATYPES_FLAGS = "-s 1 " + RNATYPES_FLAGS
    }
    else {
        RNATYPES_FLAGS = "-s 2 " + RNATYPES_FLAGS
    }

    def TOOL_ENV = prepare_tool_env("subread", tools["subread"]["version"], tools["subread"]["runenv"])
    def PREAMBLE = get_preamble("subread2rnatypes")

    // run the chunk
    transform(".bam") to ("_readcounts.tsv") {
        exec """
            ${TOOL_ENV} &&
            ${PREAMBLE} &&
    
            base=`basename $input` &&
            if [[ "$RNATYPES_PAIRED" == "yes" ]];
            then            
                echo "We are resorting and doing the repair\n" &&
                repair -i $input $RNATYPES_CORES -o \${TMP}/\${base} &&
                featureCounts $RNATYPES_FLAGS -o ${output}_tmp \${TMP}/\${base} 2> ${output.prefix}_rnatypeslog.stderr;
            else
                featureCounts $RNATYPES_FLAGS -o ${output}_tmp $input 2> ${output.prefix}_rnatypeslog.stderr;
            fi &&
            cut -f1,6,7 ${output}_tmp > $output &&
            rm ${output}_tmp
        ""","subread2rnatypes"
    }
}

