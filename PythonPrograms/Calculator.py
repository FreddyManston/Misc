#Author: Joshua Abraham
#Name: Simple calculator
#Description: A terminal calculator, with standard operators


#Menu function: Displays the operator menu
def menu():
	print ("""The operators menu is as follows:\n
1) '+' for addition
2) '-' for subtraction
3) 'x' for multiplication
4) '/' for division
5) 'pwr' to put the previous number to a certain power
6) 'root' to put the previous number to a certain root

Type either the symbol or the number that corresponds with your choice, e.g. 'x' or '3' for multiplication.
Or, if you want to exit the program, type in 'QUIT'\n""")

#Answer function: prints out answer of the sum
def answer():
	print ("\nThe answer is: " + str(num1) + "\n")



#Simple Calculator Program.
print ("This is a calculator application, to be used in terminal.")

num1 = float(input("What is your first number? "))

while True:	#A Forever Loop
	menu()
	choice = input("What operator are you going to choose? ")
	
	#Addition algorithm
	if (choice == '+' or choice == '1'):
		num2 = float(input("Now what is your next number? "))
		num1 = (num1) + (num2)
		answer()
	
	#Subtraction algorithm
	elif (choice == '-' or choice == '2'):
		num2 = float(input("Now what is your next number? "))		
		num1 = num1 - num2
		answer()
	
	#Multiplication algorithm
	elif (choice == 'x' or choice == '3'):
		num2 = float(input("Now what is your next number? "))
		num1 = num1 * num2
		answer()

	#Division algorithm
	elif (choice == '/' or choice == '4'):
		num2 = float(input("Now what is your next number? "))
		num1 = num1 / num2
		answer()
	
	#Power algorithm
	elif (choice == 'pwr' or choice == '5'):
		num2 = int(input("To what power do you want to put the previous number? "))
		num1 = num1 ** num2
		answer()

	#Root algorithm
	elif (choice.lower == 'root' or choice == '6'):
		num2 = int(input("To what root do you want to put the previous number? "))
		num1 = num1 ** (1/num2)
		answer()

	#Quit algorithm
	elif (choice.lower() == 'quit'):
		print ("Done already? Well ok then, Goodbye (:")
		break

	#Wrong input algorithm
	else:
		print ("Typo maybe? Try again, here's the operator menu one more time.")



#Make error function for invalid input of numbers.

