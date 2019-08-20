// Notes:
//  * Indentation is important in this file. Please, use 4 spaces for indent. *NO TABS*.

load PIPELINE_ROOT + "/modules/NGS/downsamplefastqSE.vars.groovy"

DownsamplefastqSE = {
    doc title: "downsample",
        desc: "downsample wrapper for fastq files (single end)",
        constraints: "",
        bpipe_version: "tested with bpipe 0.9.8.7",
        author: "Nastasja Kreim"

    output.dir = DOWNSAMPLE_OUTDIR
    def OUTPUTFILES = new ArrayList()
    inputs.eachWithIndex { item, index -> 
        path_index = item.lastIndexOf("/")
        item = item.substring(path_index+1)
        item = (item =~ /.fastq.gz/).replaceFirst(".down.fastq.gz")
        OUTPUTFILES.add(item)
        println OUTPUTFILES[index]
    }

    def PREAMBLE = get_preamble("DownsamplefastqSE")

    produce(OUTPUTFILES) {
        exec """
            paste <(zcat $input) | awk '{ printf("%s",\$0); n++; if(n%4==0) { printf("\\n");} else { printf("\\t\\t");} }' | shuf | head -n $DOWNSAMPLE_AMOUNT | sed 's/\\t\\t/\\n/g' | awk -v r1=$output1.prefix 'BEGIN {FS="\\t"}{print \$1 >r1}' &&
            gzip $output1.prefix
    ""","Downsamplefastq"
    }
}

