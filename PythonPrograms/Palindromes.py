def is_palindrome(s):
	newlist = list(s)
	if (len(newlist) == 0 or len(newlist) == 1):
		return True
	else:
		
		first = (newlist.pop(0)).lower()
		last = (newlist.pop(len(newlist)-1)).lower()
		
		if (first == last):
			return True
		else:
			is_palindrome(s)
		
		return False
	
s = "nnaa"
print (is_palindrome(s))



def are_anagrams (s,q):
	for i in range(len(s))
		q_list = list(q)
		if i in q_list:
			
			
