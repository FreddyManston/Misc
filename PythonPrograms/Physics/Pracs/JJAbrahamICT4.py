# Author: Joshua J. Abraham
# Student No.: 3475896
# Date: 13/08/2015
# Description: Estimates the y-intercept between two points, using one of three methods

def bisection(x1, x2):
	while (abs(x1 - x2) >= 10**-5):
		x3 = (x1 + x2) / 2	# Midpoint
		if (f(x1) * f(x3) < 0):
			x2 = x3
		else:
			x1 = x3			
	print ("Midpoint is: " +  str(x3) + ". With a tolerance of 10^-5")

def sectant(x1, x2):
	if (abs(f(x1)) < abs(f(x2))):
		temp = x1
		x1 = x2
		x2 = temp

	x3 = x2 - ((f(x2) * (x1 - x2)) / (f(x1) - f(x2)))
	while (abs(f(x3)) < 10**-5):
		x3 = x2 - ((f(x2) * (x1 - x2)) / (f(x1) - f(x2)))
		x1 = x2
		x2 = x3	
	print ("Midpoint is: " +  str(x3) + ". With a tolerance of 10^-5")
	
def newton(x1):
	if (f(x1) != 0 and f_prime(x1) != 0):
		while (abs(f(x1)) >= 10**-5):
			x2 = x1
			x1 = x1 - (f(x1) / f_prime(x1))
		print ("Midpoint is: " +  str(x1) + ". With a tolerance of 10^-5")

def f(x):
	return x**3 + 4*x - 10

def f_prime(x):
	return 3*x**2 + 4

print ("\nWhich algorithm would you like to use? Type in the number.")
print ("1) Bisection \n2) Sectant \n3) Newton's technique")
choice = input("Type in your choice: ")

if choice == 1:
	bisection(1.0, 2.0)
elif choice == 2:
	sectant(1.0, 2.0)
elif choice == 3:
	newton(1.0)
else:
	print ("Invalid input. Exiting.")