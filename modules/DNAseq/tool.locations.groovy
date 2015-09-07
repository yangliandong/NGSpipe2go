// variables containing the location of the used tools
TOOL_DEPENDENCIES="/fsimb/groups/imb-bioinfocf/common-tools/dependencies/" // your local tools folder
PROJECT_DEPENDENCIES= ESSENTIAL_PROJECT + "/NGSpipe2go" // please copy the bpipe tools to the project folder and include the location here

TOOL_SAMTOOLS=TOOL_DEPENDENCIES + "/samtools/1.2/samtools"
TOOL_FASTQC=TOOL_DEPENDENCIES + "/fastqc/0.11.3" // outdated (0.11.3)
TOOL_BWA=TOOL_DEPENDENCIES + "bwa/0.7.12"
TOOL_PICARD=TOOL_DEPENDENCIES + "picard/1.92"
TOOL_GATK=TOOL_DEPENDENCIES + "GATK/GATK-3.4-46"


//TOOL_COLLECT=TOOL_DEPENDENCIES + "imb-forge/collectBpipeLogs/" //
//TOOL_COLLECT=PROJECT_DEPENDENCIES + "collectBpipeLogs/" //