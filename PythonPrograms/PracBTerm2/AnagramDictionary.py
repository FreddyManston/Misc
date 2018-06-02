#Author: Joshua Abraham
#Name: Anagrams Dictionary
#Description: Goes through a text file and prints all the anagrams in that text file.

def alphabetiser(word):		#*

	sorted_word_list = []

	for letter in word:
		sorted_word_list.append(letter)

	sorted_word_list.sort()
	letterised = ""

	for letter in sorted_word_list:
		letterised += letter

	return letterised


f = open('data.ulysses', 'r')


line = f.readlines()

D = {}

for i in range(len(line)):
	sentence = line[i].split()
	#print (sentence)


	for word in sentence:

		word = word.strip(".!(-_-)?:;,'").lower()
								   #} Uses join function to join the stripped & sorted lower case version of word
		alphaword = ''.join(sorted(word)).lower() #}----K> #}  to an empty string, alphaword, one letter at a time. Removes the need to 
								   #}  use *alphabetiser function.  							
		if (len(word) <= 1):
			pass

		elif (alphaword not in D):		#} Makes a new dictionary opening for each new alphaword,
			D[alphaword] = [word]		#}  1 dictionary opening for each new alphaword

		elif (word not in D[alphaword]):		#} Makes sure the same word isn't entered into the an alphaword 
			D[alphaword].append(word)		#}  opening twice.

		else:
			pass

anagrams = 0
for k in D.keys():

	if (len(D[k]) > 1):		# Only prints out the anagrams (i.e. where there's more than one 'word' in an alphaword opening) 

		print (k, D[k], "\nAmount of letters in those words are: ", len(k), "\n")
		anagrams += 1
		
print ("There are ", anagrams, " different anagrams within this text.")
		
		
