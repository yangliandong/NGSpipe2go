// Notes:
//  * Indentation is important in this file. Please, use 4 spaces for indent. *NO TABS*.

load  PIPELINE_ROOT + "/modules/DNAseq/realignment.vars.groovy"

IndelRealignment = {
    doc title: "GATK IndelRealignment",
        desc:  "Realign BAM files at Indel positions, using GATK",
        constraints: "Requires BWA ( paramteter -M ) produced BAM file, with correct chromosome order and ReadGroup attached.",
        bpipe_version: "tested with bpipe 0.9.8.7",
        author: "Oliver Drechsel"

    output.dir = MAPPED
    def GATK_FLAGS = "-known gold_indels.vcf "

    // check if a region limit was provided
    if (GATK_CALL_REGION!=null && GATK_CALL_REGION.length()>0) {
        GATK_FLAGS = GATK_FLAGS + " -L " + GATK_CALL_REGION
    } else {
        GATK_FLAGS = ""
    }

    def TOOL_ENV = prepare_tool_env("java", tools["java"]["version"], tools["java"]["runenv"]) + " && " +
                   prepare_tool_env("gatk", tools["gatk"]["version"], tools["gatk"]["runenv"])
    def PREAMBLE = get_preamble("IndelRealignment")

    transform (".bam") to (".realignment.targets.bed", ".realigned.bam") {
        exec """
            ${TOOL_ENV} &&
            ${PREAMBLE} &&

            java -Djava.io.tmpdir=\${TMP} -jar \${gatk} -T RealignerTargetCreator -nt $GATK_THREADS -R $GATK_BWA_REF -I $input -o $output1 &&
            java -Djava.io.tmpdir=\${TMP} -jar \${gatk} -T IndelRealigner -R $GATK_BWA_REF -I $input -targetIntervals $output1 -o $output2;
       ""","IndelRealignment"
    }
    
}
