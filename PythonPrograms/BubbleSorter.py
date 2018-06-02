#Author: Joshua Abraham
#Name: Bubble Sorter
#Description: Bubble sorts a specific list

def swap(mylist, index):
	if (index > (len(mylist) - 1)):
		print ("I'm sorry, there is no index at " + str(index))
	if ((index + 1) > (len(mylist) - 1)):
		print ("I'm sorry, there is no index at " + str(index + 1))
		#exit()
	elif ((index + 1) <= (len(mylist) - 1)):						
		
		if (mylist[index] > mylist[index + 1]):
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
	


list1 = [1,2,4,3,5,7,6,8,0,9]
#check = True

#while (check != False):
#	list1var = int(input("What number do you want to add to the list?"))
#	list1.append(list1var)
#	answer = input("Do you want to add a another number? \nType 'yes' to add another number or 'no' to go and sort the current set of numbers.")
#	if (answer.lower() == 'yes'):
#		check = False
#	elif (answer.lower() == 'no'):
#		check = True
#	else:
#		print("Invalid input")

#print (list1)

list2 = list1[::]

state = False

while (state != True):
	one_scan(list2)

	
	for i in range(len(list2)):
		if (list2[i] > list2[i+1]):
			state = False
			break
		elif (list2[i+1] >= len(list2)):
			break
		else:
			state = True
	

print (list2)
























	 
		

	
