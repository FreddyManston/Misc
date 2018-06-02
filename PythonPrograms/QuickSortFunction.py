#Author: Dodds, Bruh.
#Name: Split sort, quick.
#Details: Sorts a list by splitting it repeatedly into numbers that are smaller than the first number in the list and others that are greater. Then adds the smallers plus the first number and then the greaters. Brief.

import random
import time

start = time.time()

def sort (list1):
	if len(list1) <= 1:	#Stops recursion when list is splitted enough times.
		return list1	#
	else:
		lower = [x for x in list1[1:] if x < list1[0]]	#Takes all numbers in list1 that are lower than the first number in list1.
		upper = [x for x in list1[1:] if x >= list1[0]]	#Takes all numbers in list1 that are equal to or greater than the first number in list1.
	
	return sort(lower) + [list1[0]] + sort(upper)#Recursive. Return numbers less than 1st plus 1st plus all numbers greater than or equal to first


rng = random.Random()

list1 = list(range(1,1001))
rng.shuffle(list1)

print (sort(list1))

stop = time.time()
print ("Total time taken to sort list is: ", stop-start, " seconds.")
