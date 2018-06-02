#!/usr/bin/python3
# Author: Joshua. J. Abraham
#
# Description:
#	Simple script to check if all parentheses in a string match.
#	Designed to work in command promtp.
#	Checks (), [] and []
#
# Note:
#	Could use a stack, but array is quick to code and makes for easier traversals.
#
# e.g. :
#		(Hey(Joe)How(Are))You)Doing(Today)?)) (Hmm], I do {wonder}.}{
#                       ^                  ^^ ^   ^                ^^

import sys

print("Enter the string to check for miss matched parentheses: ")
sentence = str(input())
par_count = 0
par_open = []
sqr_count = 0
sqr_open = []
curly_count = 0
curly_open = []
miss_matched = []

for i in range(0,len(sentence)):
	# () bracket check:
	if (sentence[i] == '('):
		par_count += 1
		par_open.append(i)
	elif(sentence[i] == ')'):
		if (par_count == 0):
			miss_matched.append('^')
			continue
		else:	
			par_count -= 1
			par_open.pop()
	# [] bracket check:
	elif (sentence[i] == '['):
		sqr_count += 1
		sqr_open.append(i)
	elif(sentence[i] == ']'):
		if (sqr_count == 0):
			miss_matched.append('^')
			continue
		else:	
			sqr_count -= 1
			sqr_open.pop()
	# {} bracket check:
	elif (sentence[i] == '{'):
		curly_count += 1
		curly_open.append(i)
	elif(sentence[i] == '}'):
		if (curly_count == 0):
			miss_matched.append('^')
			continue
		else:	
			curly_count -= 1
			curly_open.pop()

	miss_matched.append(' ')

for i in range(0, len(miss_matched)):
	if (i in par_open or i in sqr_open or i in curly_open):
		sys.stdout.write('^')
	else:
		sys.stdout.write(miss_matched[i])
print()

