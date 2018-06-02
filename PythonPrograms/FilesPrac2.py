print ("This program allows you to work with a text file on your computer. \n")

choice = "0"

while (choice != "7"):

	choice = input("""This is the option menu:
1) Display contacts
2) Add a new contact
3) Search for a contact
4) Edit a contact
5) Delete a contact
6) Sort the list
7) Exit the program \n
Please enter your option, e.g. '3' to search the file for a contact.\n""")

	if (choice == "1"):
		print ("Student number: \tName: \tSurname: \tCell number:")
		handle = open('contactlist', 'r')
		splitter = handle.split('#')
		

	elif (choice == "2"):
		studentnum = input("What is the student number of the new person? ")
		name = input ("What is this new person's name? ")
		surname = input ("What is his/her surname? ")
		cell = input ("And their cellphone number? ")

		handle = open('contactlist.txt', 'a')
		handle.write ("\n" + studentnum + "#" + name + "#" + surname + "#" + cell)
		
		print ("It has been done.\n")
		
	elif (choice == "3"):
		check = input
	elif (choice == "4"):
		print("")
	elif (choice == "5"):
		print("")
	elif (choice == "6"):
		print("")
	elif (choice == "7"):
		break
	else:
		print ("Typo maybe? Please try again and type in a number from 1-7")

print ("Done already? I hope you've done all that you need to. \n Goodbye (:")

