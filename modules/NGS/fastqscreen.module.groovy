
//rule for task FastQScreen from catalog NGS, version 1
//desc: A quality control tool for high throughput sequence data.
FastqScreen = {
	doc title: "FastScreen",
		desc:  "Quality control of input file against various contaminants",
		constraints: "Only supports compressed FASTQ files",
		bpipe_version: "tested with bpipe 0.9.8.7",
		author: "Nastasja Kreim"

	output.dir   = FASTQSCREEN_OUTDIR
	def FASTQSCREEN_FLAGS = "-threads" + FASTQSCREEN_THREADS + " " + FASTQCSCREEN_PARAM

	transform(".fastq.gz") to("_fastqscreen.done") {
		exec """
			export TOOL_DEPENDENCIES=$TOOL_DEPENDENCIES &&
			source ${TOOL_FASTQSCREEN}/env.sh &&
			if [ -n "\$LSB_JOBID" ]; then
				export TMPDIR=/jobdir/\${LSB_JOBID};
			fi &&
			mkdir $output.prefix;
			echo "OUTPUT:" $output.dir;
			echo "INPUT" ${input.prefix};
			echo "Config" ${FASTQSCREEN_CONF};
			testing=$FASTQSCREEN_CONF;
			references=(\${testing//,/ });
			echo \${references[0]};
			for i in "\${!references[@]}";
			do
				reference=(\${references[i]//::/ });
				echo \${reference[0]};
				echo -e "DATABASE\t\${reference[0]}\t\${reference[1]}" >> $output.prefix/fastqscreen.conf;
			done;
			fastq_screen $FASTQSCREEN_PARAM --conf $output.prefix/fastqscreen.conf $FASTQSCREEN_PARAM --outdir $output.prefix $input;
			touch $output;
		""","FastqScreen"
	}

	forward input
}

