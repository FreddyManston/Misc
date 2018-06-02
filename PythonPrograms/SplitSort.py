def merge_sorted (list1, list2):
	sortedlist = list()

	index = 0									#}
	for i in range(len(list1)):					#}
		smaller = True							#}
		for item in list2:						#}
			if (list1[index] > item):			#}
				smaller = False					#}Pops and appends the smallest values, out of list1 and 
				break							#}list2, in list1 to the sorted list.
		if(smaller == True):					#}
			swop = list1.pop(index)				#}
			sortedlist.append(swop)				#}
		else:									#}
			index = index + 1					#}

	index = 0									#}
	for i in range(len(list2)):					#}	
		smaller = True							#}
		for item in list1:						#}
			if (list2[index] > item):			#}
				smaller = False					#}Pops and appends the smallest values, out of list1 and
				break							#}list2, in list2 to the sorted list.
		if(smaller == True):					#}
			swop = list2.pop(index)				#}
			sortedlist.append(swop)				#}
		else:									#}
			index = index + 1					#}

	if (len(list1) != 0 or len(list2) != 0): 	#}
		addto = merge_sorted (list1, list2)		#}If any of the lists aren't empty from all the popping, 
		for i in addto:							#}then function recures.
			sortedlist.append(i)				#}
		
	return sortedlist

list1 = [1,5,34,87,100]
list2 = [4,5,6,67,98,100]
print (merge_sorted(list1, list2))
