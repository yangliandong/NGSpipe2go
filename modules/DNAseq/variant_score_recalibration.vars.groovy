VariantScoreRecalibration_vars=[
    outdir                   : RESULTS,
    java_flags               : "-Xmx24g -Xms24g",
    known_variants           : ESSENTIAL_KNOWN_VARIANTS,
    hapmap_variants          : ESSENTIAL_HAPMAP_VARIANTS,
    omni_variants            : ESSENTIAL_OMNI_VARIANTS,
    mills_variants           : ESSENTIAL_MILLS_VARIANTS,
    thousand_genomes_variants: ESSENTIAL_THOUSAND_GENOMES_VARIANTS,
    snp_filter_level         : "99.7",
    indel_filter_level       : "99.7",
    max_gaussians_indels     : 4,
    max_gaussians_snps       : 6,
    bwa_ref                  : ESSENTIAL_BWA_REF
]
