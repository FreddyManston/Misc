def merge_sorted (list1, list2):
	sortedlist = list()

	if(len(list1) < len(list2)): 
		for index in range(len(list1)):		
			if (list1[index] < list2[index]):
				sortedlist.append(list1[index])
				sortedlist.append(list2[index])
			else:
				sortedlist.append(list2[index])
				sortedlist.append(list1[index])
			remove = index
		list2 = list2[remove+1:]
		for index in range(len(list2)):
			sortedlist.append(list2[index])
	
	elif(len(list2) < len(list1)):
		for index in range(len(list2)):		
			if (list1[index] < list2[index]):
				sortedlist.append(list1[index])
				sortedlist.append(list2[index])
			else:
				sortedlist.append(list2[index])
				sortedlist.append(list1[index])
			remove = index
		list1 = list1[remove+1:]
		for index in range(len(list1)):
			sortedlist.append(list1[index])

	else:
		index = 0
		for i in range(len(list1)):	
			smaller = True	
			for item in list2:
				if (list1[index] > item):
					smaller = False
					break
			if(smaller == True):
				swop = list1.pop(index)
				sortedlist.append(swop)
			else:
				index = index + 1

		index = 0
		for i in range(len(list2)):	
			smaller = True	
			for item in list1:
				if (list2[index] > item):
					smaller = False
					break
			if(smaller == True):
				swop = list2.pop(index)
				sortedlist.append(swop)
			else:
				index = index + 1

		if (len(list1) != 0 or len(list2) != 0): 
			addto = merge_sorted (list1, list2)
			for i in addto:
				sortedlist.append(i)
		
	return sortedlist


def sort_method2 (list1):
	uneven = False

	if (len(list1) == 0 or len(list1) == 1): #Checks whether or not the list has 2 or more items.
		return list1
	else:
		if (len(list1) % 2 != 0):
			uneven = True
			last = list1.pop()

		left = list1[0:int(len(list1)//2)]
		right = list1[int(len(list1)//2):]
		
		if (len(left) == 2 and len(right) == 2):
			print (left, "   ", right)
			if (left[0] > left[1]):
				swop = left.pop(0)
				left.append(swop)
			if (right[0] > right[1]):
				swop = right.pop(0)
				right.append(swop)
			if (uneven == True):
				if (last < left[0]):
					left.insert(0, last)
				elif (last > left[0] and last < left[1]):
					left.insert(1, last)
				else:
					left.append(last)
			print (merge_sorted(left,right))
			return merge_sorted(left, right)
		else:
			left = sort_method2(left)
			right = sort_method2(right)

		if (uneven == True):
			if (last < left[0]):
				left.insert(0, last)
			else:
				for i in range(len(left)):
					if (last > left[i]):
						last.insert(i+1, last)
					break
	
	return merge_sorted(left, right)
		

#list1 = [8,7,6,5,4,3,2,1]
#print (sort_method2(list1))

list2 = [1,2,3,4]
list3 = [5,6,7,8]

print(merge_sorted(list2, list3))



