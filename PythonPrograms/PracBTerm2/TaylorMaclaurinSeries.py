#Author: Joshua Abraham
#Name: Taylor-Maclaurin Power Series
#Description: Uses Taylor-Maclaurin Power Series method to calculate the sin of a value

from math import pi,sin,factorial
 
def taylor(x):

	the_sum = 0

	for no in range(18):
		the_sum += pow(-1,no) * (pow(x, 2*no+1) / factorial(2*no+1))

	return the_sum

for test in range(0, 11):

	test_number = test*pi/10

	print("This is the answer using the actual sin function: \t" , sin(test_number))
	print("This is the answer using the taylor series function: \t" , taylor(test_number), "\n")

