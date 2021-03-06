#Author: J.J. Abraham TM
#Name: Bubble Sorter
#Description: Sorts a shuffle list of numbers, using the bubble sorting method.

import random
import time

def swap(mylist, index):
	if (index > (len(mylist) - 1)):
		print ("I'm sorry, there is no index at " + str(index))

	elif ((index + 1) > (len(mylist) - 1)):		#}Dummy equation
		index = index				#}to skip range error problem			
		pass

	else (mylist[index] > mylist[index + 1]):
			value = mylist.pop(index)
			mylist.insert((index + 1),value)

def one_scan(mylist):

	count = 0			#}
	rang = []			#} 
					#} Creates a seperate list, using the length of the list that needs sorting,
	while (count < len(mylist)):	#} that can be used to index the list needing sorting.
		rang.append(count)	#}
		count = count + 1	#}


	for index in rang:		#} Goes through the list, one element at a time (using indexes from the 'rang' list
		swap(mylist, index)	#} and bubble sorts the list once.



rng = random.Random()

list1 = list(range(1,1001))
rng.shuffle(list1)
list2 = list1[::]

state = False
start = time.time()

while (state != True):										#}
	one_scan(list2)										#}
												#}
												#}
	for i in range(len(list2)):								#}
		if ((i + 1) > (len(list2) - 1)):	#}Dummy equation 			#}
			i = i				#}to skip range error problem		#}
												#}While loop to scan through list
		elif (list2[i] > list2[i+1]):							#}to check if list is currently sorted.
			state = False								#}If not, then sorts list again.
			break									#}
												#}
		elif (list2[i+1] >= len(list2)):						#}
			break									#}
												#}
		else:										#}
			state = True								#}


print(list1)
print (list2)

stop = time.time()
print ("The time taken to sort this list was: ", (stop - start), "seconds")



