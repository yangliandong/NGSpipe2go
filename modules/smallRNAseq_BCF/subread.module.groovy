//rule for task feature_count from Subread package, version 1
//desc: Counting reads in features with featureCounts
SubreadCount = {

	doc title: "SubreadCount",
	desc:  "Counting reads in features with feature-count out of the subread package",
	constraints: "Default: strand specific counting.",
	author: "Oliver Drechsel, Antonio Domingues, Anke Busch"
	
	output.dir = SUBREAD_OUTDIR
	def SUBREAD_FLAGS = 	SUBREAD_CORES + 
				" " + SUBREAD_GENESGTF + 
				" " + SUBREAD_EXTRA + " "
						
	if(SUBREAD_PAIRED == "yes") {
		SUBREAD_FLAGS = "-p " + SUBREAD_FLAGS
	}
	
	// no|yes|reverse
	if(SUBREAD_STRANDED == "no") {
		SUBREAD_FLAGS = "-s 0 " + SUBREAD_FLAGS
	}
	else if (SUBREAD_STRANDED == "yes") {
		SUBREAD_FLAGS = "-s 1 " + SUBREAD_FLAGS
	}
	else {
		SUBREAD_FLAGS = "-s 2 " + SUBREAD_FLAGS
	}
	
	// run the chunk
	transform(".bam") to (".raw_readcounts.tsv") {
		exec """
			export TOOL_DEPENDENCIES=$TOOL_DEPENDENCIES &&
			source ${TOOL_SUBREAD}/env.sh &&
			
			echo 'VERSION INFO'  1>&2 ;
			echo \$(featureCounts 2>&1 | grep Version | cut -d' ' -f2) 1>&2 ;
			echo '/VERSION INFO' 1>&2 ;
			
			featureCounts $SUBREAD_FLAGS -o $output $input 2> ${output.prefix}_subreadlog.stderr
	
		""","SubreadCount"
	}
}