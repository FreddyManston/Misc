#
# Makefile---
#            make
#
#            makes $(D).pdf
#
#            make clean
#       
#            Gets rid of all the trash created but first backs up your files
#
#            make cleanup 
#       
#            Gets rid of all the trash created and all the backups
#           
#
# Depending on what has been commented out or not this
#            creates a 4up PostScript copy and 
#            corrects the access codes, copies the files to the
#            web pages in ~/www/latex/
#


D=jitteredhuffmancode
Dps=$(D).ps
Dtex=$(D).tex
WWW=../../www/latex/

all:	$(Dps)

$(Dps):	$(D).dvi 
#	dvips -o $(D).ps $(D).dvi  # Creates a PostScript file
#  pstops creates the 4up-ps  
#	pstops '4:0@.55(0,14cm)+1@.55(9.5cm,14cm)+2@.55(0,0)+3@.55(9.5cm,0)' $(Dps) 4up-$(Dps)
#  creates pdf from dvi 
#	dvipdf $(D).dvi            # Creates a PDF file from the .dvi file
#                             # BEWARE  PostScript cannot handle .jpg files
#	chmod 644 $(Dps)
#	chmod 644 4up-$(Dps)
#	chmod 644 $(Dtex)
#  Uncommented this moves ps and 4up-ps pages to web location at $(WWW)
#	-cp 4up-$(Dps) $(WWW)
#	-cp $(Dps) $(WWW)
#	-cp $(Dtex) $(WWW)



$(D).dvi:	$(D).tex *.bib #les*.dvi
	rm -f *.aux
	pdflatex $(D)
	bibtex $(D)
	pdflatex $(D)
	pdflatex $(D)
	@echo "\n$(D).pdf can be now be read with acroread\n"
	@echo "Check your bibliography using \nbibtex $(D)\n"

#  Instead of using 'latex' the processor 'pdflatex' 
#  has been used to make the pdf directly.
#  'latex' or 'pdflatex' needs to be run to let 'bibtex' know what to do.
#  'bibtex' handles your bibliography vert tidily.


#les*.dvi: les*.tex 
#	echo "dummy operation on $(@)"

clean:
	-rm -f $(D).aux
	-rm -f $(D).bbl
	-rm -f $(D).blg
	-rm -f $(D).cre
	-rm -f $(D).crf
	-rm -f $(D).dvi
	-rm -f $(D).idx
	-rm -f $(D).ilg
	-rm -f $(D).ind
	-rm -f $(D).ind~
	-rm -f $(D).log
	-rm -f $(D).log~
	-rm -f $(D).ps
	-rm -f $(D).pdf
	-rm -f 4up-$(D).ps
	-rm -f $(D).toc 
	-rm *.aux
	-rm *~
	-rm figures/*.bak
	 mkdir ../backup
	-rm -r backup
	-cp -R * ../backup/.
	-mv ../backup .

cleanup:
	-make clean
	-rm -rf backup

cleanall:
	-make cleanup
