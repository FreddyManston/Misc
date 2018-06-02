def alphabetiser(word):

	sorted_word_list = []

	for letter in word:
		sorted_word_list.append(letter)

	sorted_word_list.sort()
	letterised = ""

	for letter in sorted_word_list:
		letterised += letter

	return letterised

print (alphabetiser ("annagrams"))
