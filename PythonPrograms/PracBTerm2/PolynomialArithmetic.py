#Author: Joshua Abraham
#Name: Polynomial Arithmetic
#Description: Does addition, subtraction and multiplication with two polynomials

def add_poly (poly1, poly2):

	added_poly = []

	if (len(str(poly1)) == len(str(poly2))): #If the polynomials are the same length
		i = 0
		for number in list(str(poly1)): #Adds each consecutive terms

			added = int((list(str(poly1)))[i]) + int((list(str(poly2)))[i])
			added_poly.append(added)
			i += 1

	if ((len(str(poly1))) < len(str(poly2))): #If first poly is smaller than second poly
		
		lengthoflonger = len(str(poly2)) - len(str(poly1))
		poly2index = 0

		for i in range(0, lengthoflonger): #Prints the first part of the second poly
			added_poly.append(int(str(poly2)[poly2index]))
			poly2index += 1				

		for number in list(str(poly1)): #Adds the remaining consecutive polys
			added = int(number) + int((list(str(poly2)))[poly2index])
			added_poly.append(added)
			poly2index += 1

	if ((len(str(poly2))) < len(str(poly1))): #If second poly is smaller than first poly
		
		lengthoflonger = len(str(poly1)) - len(str(poly2))
		poly1index = 0

		for i in range(0, lengthoflonger): #Prints the first part of the second poly
			added_poly.append(int(str(poly1)[poly1index]))
			poly1index += 1
				

		for number in list(str(poly2)): #Adds the remaining consecutive polys
			added = int(number) + int((list(str(poly1)))[poly1index])
			added_poly.append(added)
			poly1index += 1
	
	return added_poly

def subt_poly (poly1, poly2):

	subtracted_poly = []

	if (len(str(poly1)) == len(str(poly2))): #If the polynomials are the same length
		
		i = 0
		for number in list(str(poly1)):

			subted = int((list(str(poly1)))[i]) - int((list(str(poly2)))[i])
			subtracted_poly.append(subted)
			i += 1

	if ((len(str(poly1))) < len(str(poly2))):
		
		lengthoflonger = len(str(poly2)) - len(str(poly1))
		poly2index = 0

		for i in range(0, lengthoflonger):
			subtracted_poly.append(int(str(poly2)[poly2index]))
			poly2index += 1		

		for number in list(str(poly1)):

			subted = int(number) - int((list(str(poly2)))[poly2index])
			subtracted_poly.append(subted)
			poly2index += 1

	if ((len(str(poly2))) < len(str(poly1))):
		
		lengthoflonger = len(str(poly1)) - len(str(poly2))
		poly1index = 0

		for i in range(0, lengthoflonger):
			subtracted_poly.append(int(str(poly1)[poly1index]))
			poly1index += 1
				
		for number in list(str(poly2)):

			subted =  int((list(str(poly1)))[poly1index]) - int(number)
			subtracted_poly.append(subted)
			poly1index += 1
	
	return subtracted_poly

def mult_poly (poly1, poly2):

	multi_poly = []

	if (len(str(poly1)) == len(str(poly2))):
		i = 0

		for number in list(str(poly1)):

			mult = int((list(str(poly1)))[i]) * int((list(str(poly2)))[i])
			multi_poly.append(mult)
			i += 1

	if ((len(str(poly1))) < len(str(poly2))):
		
		lengthoflonger = len(str(poly2)) - len(str(poly1))
		poly2index = 0

		for i in range(0, lengthoflonger):
			multi_poly.append(int(str(poly2)[poly2index]))
			poly2index += 1
				
		for number in list(str(poly1)):

			mult = int(number) * int((list(str(poly2)))[poly2index])
			multi_poly.append(mult)
			poly2index += 1

	if ((len(str(poly2))) < len(str(poly1))):
		
		lengthoflonger = len(str(poly1)) - len(str(poly2))
		poly1index = 0

		for i in range(0, lengthoflonger):
			multi_poly.append(int(str(poly1)[poly1index]))
			poly1index += 1
				
		for number in list(str(poly2)):

			mult =  int((list(str(poly1)))[poly1index]) * int(number)
			multi_poly.append(mult)
			poly1index += 1
	
	return multi_poly


poly1 = 12343472
poly2 = 12347
answer = mult_poly (poly1, poly2)

string_answer = ""
string_poly1 = ""
string_poly2 = ""

for num in answer:
	string_answer = str(string_answer) + str(num) + " "

for num in str(poly1):
	string_poly1 = str(string_poly1) + str(num) + " "

for num in str(poly2):
	string_poly2 = str(string_poly2) + str(num) + " "

print (string_poly1, "+ \n", string_poly2, "\n------------------------------ \n", string_answer)












