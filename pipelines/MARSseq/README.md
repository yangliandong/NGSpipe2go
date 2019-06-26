# scRNA-Seq pipelines

Analysis pipelines for single cell RNA-Seq protocols. The analysis workflow is based on the Bioconductor package *scater* and the Bioconductor workshop published in F1000 Research: Lun, A. T. L., McCarthy, D. J., & Marioni, J. C. (2016). *A step-by-step workflow for low-level analysis of single-cell RNA-seq data.* F1000Research, 5(0), 2122. http://doi.org/10.12688/f1000research.9501.1.

## MARS-Seq (massively parallel single-cell RNA-sequencing)
The protocol is based on the publications of Jaitin, D. A., et al. (2014). *Massively parallel single-cell RNA-seq for marker-free decomposition of tissues into cell types.* Science (New York, N.Y.), 343(6172), 776–779. https://doi.org/10.1126/science.1247651 and Keren-Shaul, H., et al. (2019). *MARS-seq2.0: an experimental and analytical pipeline for indexed sorting combined with single-cell RNA sequencing.* Nature Protocols. https://doi.org/10.1038/s41596-019-0164-4.

The MARS-Seq library preparation protocol is given [here](https://github.com/imbforge/NGSpipe2go/blob/master/resources/MARS-Seq_protocol_Step-by-Step_MML.pdf). The sequencing reads are demultiplexed according to the respective pool barcodes before they are used as input for the analysis pipeline. All analysis steps are illustrated in the pipeline [flowchart](https://www.draw.io/?lightbox=1&highlight=0000ff&edit=_blank&layers=1&nav=1&title=NGSpipe2go_MARSseq_pipeline.html#R7V1bk5u4Ev41rso%2B2AWI6%2BNcczmbZHdmtrLZl5RAwibB4AD2jPPrjyQE5iLb2AMGz2SzlRgBQq1utb5utVojcDV%2FehvBxexjiLA%2FUiT0NALXI0WRgaWSf2jJOi0xDSMtmEYe4g9tCu69X5gXSrx06SEclx5MwtBPvEW50AmDADtJqQxGUfhYfswN%2FfJXF3CKawX3DvTrpV88lMx4qaxbmxvvsDed8U%2BbCqfPhs6PaRQuA%2F69IAxwemcOs2o4jfEMovCxUARuRuAqCsMk%2FTV%2FusI%2B7dasx9L3brfczZsc4SBp8sI76YM7%2B2Qm%2Fmp2Z396d3%2F77de7ccaAFfSXvC9Giu6TCi%2BRt6K963vTgN3Qfy5pUy8j1g35Jfk15f%2By1%2ByoWkKaxOrKSllnJOus72fJ3Ce%2FZHLPhzb2L%2FMuvQr9MGIPgVv2H3kkTqLwR84k0omXbhgkXKJknbYbxjOMeI2snvzK9Xy%2FUOmNTv%2FklWZ3GA%2FB5TSCyCN9Wyl2wrnnkEuJPuLDOOa%2Fc%2FZKOZFF3nB2rXCU4KdCEefVWxzOcRKtySP8rmVx1vAhlYnRY0E%2BdV42K4gmUHkh5GNimle9EQ7yg8uHWFZ%2BfUmuH6R%2F%2F%2Ftwe3cTzWX08Hb9fqxqNd5hRIYRv8S%2BHT7ebAoKfU%2B7JIySWTgNA%2Bj%2FGYYLzpDvOEnWnHlwmYSkqCAO%2BMlL%2FqWvTzR%2B9ZVXRn9fPxUv1tlFQEgtvEQvv2b10YvNa%2Bxq8x66oIqEXDqUq5THtPDW87Pm1EXv%2B3K%2ByMjn4rGV83G4jBzebSvn09%2F3X5Yflte%2F%2Fnt4%2F3D7NV79NwYmV3wwmuJkx4MWr5F2%2Fk5JirAPE29V1nHPEQthc%2BTfOmSoOgRIclmHyHUlokpWXYloVldKRJNrzCsqkY2WOIEmye4cpkk2uqNFTVISuGfokIYqBIC%2BVMjnh88%2Fvs%2FMbz%2F%2FfUiU22%2Bfvsi6PTbPRSbqjBP2Y7fMU80%2B1T3YrezLapvq1RJjM41Pb4xjxpoL8oCsLp4E08GVMrq4nEMvoD3qLbDvEfVJCi93zxTpV3dPIHubnNkoWaPk7dNVvIBBtQxSTnpJhew5jOIY%2F5xkxEzIJBWu1sWqs97PSgykG6alSxoZFCYGRDM7xA5SATR027VsMMamrRkaxiq5BLpt24qDZAdoigV123CABUxHdTEufWQWYbf0mVmSUFvrggqHcjv1ktnSnpB5ilx4c9sNiUySn5%2Fe3tOmK9OQXNh%2BaFMRgnGCCRtuM6Ji8vvjxd09IZTd3k%2FykfKxveqM5VAgBiJuHS40R8t0KyNjzHSOl0CbvF0YG8QCx64XeIkX0jHzxqZ3%2FmhzsPRPtx9CFDN1Fy%2BwwxQescMpodTqDtHSpxJ4%2FvRhIttB4kGqkWGAcuLGlGzPJbCCTTOQqHU6%2FI4guAUZfMLOMqH9XZDBLS3ZDtnbQLqyUkK6Zh3oAkMAdGWlBaArnqUF82SlCwjcX9CfRM0uiGFAiU8xSwYwzKwg9z2pwu7aOVE37kO51mWKwL%2BQlTVGG%2Fx7f4Uekzb%2BsbGilRhmlCsIXTcmIKjKhLzRzzBXrT7BZvb7awl47jNASubHxhrZYoBsA6nHYFK9qUExKJeEvschUdd4dvhEFZ4XTFOVZ4cRwtGYFJOLFKTwccEUokQGgZbfKTqB6e2RArBK%2F%2BRPLCBCed3KrvmjOZZ0iHaNCPaKJ8lTyZdSRZDI0pFsaARHQhmakiqbMjHwVVm1FRNiAMeG60imbLkQqZJiIKgoKkGNuiPJmuNqlmVrkia5BDD2gyC3Epr2UvX2odhvv7MpLc3AVl14tktGdSLF81IfOkSWSZMcJhqFCqXaU7kAFZ5StktRYodoXSusEZqgaomXFRB%2BkU9f3zDwAf117BGmkNEoTVPAxdY5pKzvqYhTDkopAiDP6XBONONlYMeLlAqCzidpL%2Fzv8yr%2B8kBIefO%2Fz%2BMvD39MCv3uCXhRb2W9RMjE%2BmO0sN4Lh%2FTLWzLOF4SIgOCuONVdZMAFuY6sSuFQCWpY%2FytpGC0UDRlang77LSiWoivPgf4Fd3EnFA9cZg5vH7v0rZA85frMI%2BgyJ2ARGTzOvATfEyVAa3yM4GLXfN0czKllzy9QDQG6E8A7sys8LO9ePfqNu8q9pQwMeP0T4%2Biz%2FZ0uvhMtT9dYXiywKivyrbBKc0zD0F3FdWVVtTRXA44MNUuxDNdFrmqPDUszoSa7wJKwjWTJcmXbtDCWVclUbaSrBG8BYlz3BKu2kJn2kHgyO8Cd9toAVEzwjp87P46exHK44KQqNauW4Y2DYcXBk7ANIydE7ZNRqVdEQFe4YhGGfnv0pLVJ74kUSW%2BIYqfaMHSpoHo%2Bpjz6oxcaiW5vkWm8Ok5lsJzbOOqFLrqK2jpVrFLpjU9wQ09kOa1KJCeLVLqcBz0zjOnj9miTHPKGzP6iP6U3zN5kI%2FCRfqkXGqepBdgWjdOCQZkpk1Rrnp60yWTSHmEwoLgzTGbMMYBgArsi6TDrbbeVohTgMzdrWjX32jftZE3kuBeYdrJpHQz7yWUB%2BR9g7uVRr7%2FNvSbmXuPAnUH52eU9wSAvwx5ka8vE5ApcbzraYRDalk7sOdWxDEfVkORAxQKuCl1Amo0NyxxDR1cNHWi6AlxFNxCUbE2FEoCSrNsmVA0DA83W%2B%2FKzb6OTmwblu79NwsYezXyuY7EZlNzHMPpBl%2FlHdJtAAKdshoxwqiYE%2BOmeLoXyxXYeeJq10g8dGiFQlEqKIIKQvhFgTNTpTv%2F6bz%2FwWTSsRwd1%2B4hFBVozxKJ35YxWeo04PTd0koWuDAad7HNGL4RTypw03wvSWUNabPBGWj5mI4Pe0wv3iIAnYz5aLti8EaTRVtt2LmQFf21C8kRBWnYj5bCols1qTx1Fajrs6U1TDJEuGbg6FCjlEWuTFYziBrGttq1JJkJABrJK9wwiKMvQNhSXTFuujvBYdmXdcB1Zl1XTwrqjaQoCBkaWjW0EFNUhvxTVsDtHTHlcYQEv7SU37bNtjzVGUBzqHiIn3UhF1fMUhSuPOnVLoYoiad%2BJOlgLWPd%2BIi%2BWOqlEueC76WuUVmFIpPQmxUIMBR3uKyr06l6%2FgbLbbzC8BWFNAg29BvLhk%2FDxXgORQVmZqLuNmsw%2BONiwSbUMpcoVtBI2Kdyi0%2Bu2rT4BUytbezI%2BNUNQfblzFFHM8mAQ1aVHhgKZrOekJxwadUUzBBQj%2FV8kpqJETqiRT7d0NMFUGjQlV3V028EImSowsa0AZAIZ27qEXHNsOsCF2JGAK9u6ogFX1aCFFRtbyNXIq%2BRJWXLoZu8eMNVectM%2B2%2FbYoV6pKg45kj9ksogbskeVNAe5UCddb5q2gh3TMV1g2bplOa6q4rFmIdXWdF1zJQNDxzVtCWLyhuI4wDQVSBCzZWq21R97dlBb4E79qSNchn0D203oK9M2KS5gZI2yTTm5FI744l2Efy69CNN7zjJOaJ%2FXVJUofKMCNweNHvVsF8Ve9Ch15sLReoeK6qG9%2BEqgInh9WFGwf7%2BdPeGNFwb1flxtOei6JfPG31dMzTZBZD%2BXRKsltIWbmI5UfcJH1my2CZI21veCH%2Bk3W53UyGPkb5fc%2BOlM0uJ8qtpr7oMiTq%2Bb%2ByK9U1HifInqT3Z1DfQtqpslJuEVS6O2%2FfKaYpVUhCKIEhcmGTrCMd%2FEJyDMGLJnw153aYfKmkTZrUq6S%2BnR1HTUJKHeeYZKYK9eRBFcFx5Y0Fkm3j7taJWcM6ouVaQirfHYKUcoI8pu98RrkZGWWV%2FnLagu5FW27aZCyt%2FaMP25MgR4OsG2ZEgIWwa0P2WPHG2DLWA4sKWp0lJP5fASslx%2F8SwvMbjb7EWNWW70yXL5bPKPDYRbHdkVzbilnI0pOQxuAasPyGdk0DODBeXpeu%2FzmqI%2FZ3pvbKLeP1zcNTZQ7zCPz1ssaJBgl6bo3aeL1L0aEwYfbouqBc50aYt2m7FH7dn2FPdt3clIneHje8ouaRPjU9FRdI2r0M18iatszdNurAbnzT2EmAqrcGRTcsf7AYy2ZByNwgSmEYGpXuJjlzRLuyT%2Fk767oqpMu6ZZGjSa1S67Jv%2FTx6PkKgxI1dBjrMVEXB9xnIzqSVJbEAJVkiflPECZm3KfYxmoB0tBQ5ZvTx6zf%2FGBJcriSxDSEYuen5fJYknVGM1gTkXmoqbEyM2fzi4V1t8aZx6OE%2BZkeEzDSWk2kU27m8TbPD%2BItSiwWZbfWzj3fCpr77C%2FwrTW0SnWTwzdLIk5AA3zMXQWAps1YDByLtVEPcLx0k92LvH3J%2BwOQZlFEX%2FzSEDAKFsVpBcho3A59%2FjqH3Nqj2iKxjFaLnwvXTfcnZ3xpAugr35U6hyI7h%2BVh%2B%2BkazgqzcGPSj%2BcDnRIkpaNs%2BHohL5PwB5bhk9nHwwdOj6zSWpYAt6BMBtSU2HuLNd7ry7VwZ4acbwfIDvaY%2F8REZz1A9knmrV7MFqtjqkjTE2fgSq2Y4PTrm9SsiZ3c7QrKM1Gtmxix1UMR3FNGyLbdRQLYkszsGRJ8ljBpmpR1KqTEQwUWYaWizQMVYAkG2mGa1hQ1fTyHssugtI4lLrN2XUbz7xg%2FY2nAv%2BWlhND%2BVsar3W7rQvS7qvcPX344PXNhBFAmjGZYX%2BBo3hyt4tVUDYdLBvINGlqd0cGwNEAQBbCpoSQA8aOKztY0lTgKgjapu7Kli3bsuZgmg1edg1Zs7GGzSGyak9fZDwTP3Y24YUfQ%2BS5VPkyoWMGBLcYRoWQwULoYb6lZRN1mBCOxTOi0PIclOkulwJxh8UYvjwwLwvD7UQxim3kABcDoOdvMxUcMXWy4Lgc2%2FAPb4BNp9EMauvbSLcsQ4DyMgTQmkUztLgi4QUujvAT0WHenPVTw8UJRLXBPN1eSn21TCdkm%2BDSsDoWTOd7dgS5IHe%2BelEh5uCFDPVUQXXdBtEBpd%2BFDPGy94CiW7qJyT1dpEN2DuLwY3LjpU19jkoUwGS9wPFR%2BoU5OhkMYXtqyXCntK8X%2BDRapUrD4WpFexFqRZUGGJubrcINwcPTzWl%2Brbpvmp6mobYez%2Fm8KJxXmy2lnfmi8SEqz42MOyp6RzXLMFjTStE4e5%2FXdbkiYd1E7%2FCJ4Fu68HZgGA97icXx0AUAgpILCwObFboO57PNHkpOx%2BHzWBFNnM88Vo3z0QRrbP3D4xev4U4Ij42G6s7sKTtUri1sOFfsx8aqxCHDlqVatr3pF296iu1paQsPVxXFieR8VEUV8mr6AC3pXo%2BP6xPxtqMcBIfcC7tZFUvKyXTDBUL%2FfHx%2FmZ5b8EDGqkQ3uP4sx0SI9EVxqQEi5p8nFeWO%2B%2FwkBMmNmJ%2F%2FjnUH%2FQDbi8okGyJmajMX3p28MzynvLJxEgBDqCKQiROShKzZh6uo4iHW56OiqmhGMYeIZozfaKYthaU1Dbno3dk3xQG%2BDNH6KlwpjTFNlJlHZAjAKYvdXTHdQ2ujH8TBlK5LnsLTRz9Jc9ySxigH65OUT2enT2pePnOAkEfpFfOcv%2F%2Bn8e6tQfh%2FdDBM%2Fw%2FBHIe5foj0sZNV0ticLF6bZxapwbF44XtJ0vVWrw2Kysg5HDm9jP1euiA8tff9XmZG1lACFevh10kEnR8DjVNMHSOUZN5I7mFdeTFN9xOzDQ87zZlBBCi1IO1G5rrIneonTHkvnMTPZif1IOdw8ywSuGatHGYC1ztM44MCh862b3EQlg603DGP96%2FXUgTBto%2FTw74RfmLLR9MSEdVgYBfDZBlRYtm5Lx7Tfewb08TtPQh1k%2BOSx58W81iy88z35a0%2FKon6wLJaliGJIVqasqy6ku4uq6XZe1bLXIe83qyWO7fUnONZZ7lyzfc7sLG1G0O%2BtuO60i4p710fpekpIVHfLHaA6HF2yEW%2BMzn10YuSWab2ZSGKn9iCi%2Fj552u%2ByOOtBtuwUX%2Fnbp1om0Sml%2FcZJkZnmyR6Xa04bkV1dJBlcuJdorLcOEBZaCH1Zb3k7e7F%2B%2FI%2BaLJLFD5WDjIekPclWz%2FOM1L88haL8sFH%2FdgaAZyn0yeZHVfUpqBOIO4aWkCeKx9zoNN0%2F9opbaUw9OXJnTxJl7qnv4bcSuWIVp61q61yNEHT%2Baw7Gw5YPaqxZk5kmtWutFl0QGrMhvONEnuFrmI1s8D7y9sxoF0dLyJvhyU3BGRZoozeT1DN9QHban%2FHt%2FA3XXnlHUIn%2FNTFyKZ6Mvx%2FoPAxGGXZNkanWWnNsgVQEg5ebbWKDDif1VbDrFh5mjmpr0Cdcr31nfTBnX0yE381u7M%2Fvbu%2F%2Ffbr3Xj7cmtNuqg2Fs42VQeTKppU%2FsRTCjA30ptWV5tU7K2TCs%2FpWWCTMP8mnUsqRbU0oFvTforkoqxXWxANAnwq%2B96VumCoAsFoI02CUArqh37adISPNsm6GnjA94%2B6LvpOFKEu8n6rXfXdc1b89CrWLHhcs%2B7cFLKOFZkhcE7lNLBj%2Bs9ic%2B71hju9Y8ojgeQh7roupEtWGg7NbEt66%2BJ1yuWonfL9elejhN1yhotR3F9%2Bm66r7BiPr23haWdnvNqVl8E2rMcloU7mGLPhHNNGxnWhLuszEbWXev1vw4rbbJBBSK%2FAGVYTTwXUJ3QxBNI7Es%2FtGZlzr%2Fr7hPSnIz7glzF0GbNNNVza8lx9r8bEVDJ3RG82Zt0nfx0maXpoSD2BadgboknZKdAQRXSwAI5XxLQ8Yn8v01rIhv7V8j88eO9v7Pv7p3Adrj98%2FfzP641Z3uNkFnZWUx9zlmJ%2BOD5mnqud%2BQ7%2BpNnlG2dkCBdrRnL8g36CJaZP91Ln8zkvzKb1Dh3Ocy%2Bm1gIMcLik15wq5srK%2Fc6K0PO8nZ9n53hWsxjaHVnoT%2Bl2FnZtzxFHB2kWcvEXy6jJ5og%2BcpkJu1CwH2KXVjp9iNGuVjdyZy0jf31J9zHhZP%2FI2UhHepWkW53A9dg6sOcPGGqWWjk8S82C1YveL1Afa8BowV8oTj0g9Tu0Tn%2B85vbsJU3m4o7SnDTc1%2F3yz7%2Ft5Mjj57H8uTvEWtnkDbjXp%2Bkmb0XXKuLWwQncytnkLTm18hDrWqUPSaoe3gqsww57VVXlOZLU2Ki4WiYQwUXS2JjISooZlSI8D1fUH8CqYj4cnraJpxHIK%2B4hD5PDKdwV07I3t9ZJLYsathEMkK1wp5pAAAwxO1zWxgHHfibEmJgPNfgzb5x0hmGgzxLv6r4cVZYFEVttBYKSS6ItkqLWJWN29jFEVKHe%2FB8%3D). Specify desired analysis details for your data in the respective *essential.vars.groovy* file and run the pipeline *marsseq.pipeline.groovy* as described [here](https://github.com/imbforge/NGSpipe2go/blob/master/README.md). Since the analysis will need custom adjustments after initial analysis e.g. for QC thresholding, a customisable *DEreport.Rmd* file will be generated in the output reports folder after running the pipeline. Please go through the steps and modify the default settings where indicated. Subsequently, the *DEreport.Rmd* file can be converted to a final html report using the knitr R-package.

#### Programs required ####
- FastQC
- STAR
- Samtools
- Bedtools
- Subread
- Picard
- UCSC utilities
- RSeQC
- UMI-tools
- R

