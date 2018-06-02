# Name: Joshua Abraham
# Student Num: 3475896
# Assignment: ICT 5
# Date: 20/08/2015

from visual import *

# Midpoint Rule:
def midpoint(a, b, n):
	delta_x = (b - a) / n
	
	sum = 0.0
	# Run through the range of [a, b] incrementing by delta_x
	for xi in arange (a, b + delta_x, delta_x):
		sum += f(0.5 * (xi + xi + delta_x))		# Midpoint between xi and xi + delta_x
		
	sum = delta_x * sum	
	return sum

# Trapezoidal Rule:
def trapezoidal(a, b, n):
	delta_x = (b - a) / n
	
	sum = f(a)	# Do the first summation
	i = 2		# i used to identify x1, x2, x3, etc.
	# Run through the range of [a + delta_x, b] incrementing by delta_x
	for xi in arange (a + delta_x, b, delta_x):
		sum += 2 * f(a + (i * delta_x))
		i += 1		
	sum += f((b + delta_x) + (i * delta_x))		# Do the last summation
	
	sum = delta_x / 2 * sum
	return sum

# Simpons Rule:
def simpons(a, b, n):
	delta_x = (b - a) / n
	
	sum = f(a)		# Do the first summatoin
	i = 1			# i used to identify x1, x2, x3, etc.
	for xi in arange (a + delta_x, b, delta_x):
		# If dealing with x2, x4, x6, etc.
		if (i % 2 == 0):
			sum += 2 * f(a + (i * delta_x))
		# Else dealing with x3, x5, x7, etc.
		else:
			sum += 4 * f(a + (i * delta_x))
		i += 1	
	sum += f((b + delta_x) + (i * delta_x))	# Do the last summation
	
	sum = delta_x / 3 * sum		
	return sum

# Function definition: 1 / x
def f(x):	
	return (eval(func))

# Printing function:
def toString(a, b, n):
	print ("--- f(x) = %s , a = %d , b = %d , n = %d ---\n") % (func, a, b, n)
	print("Midpoint Rule:     " + str(midpoint(a, b, n)))
	print("Trapezoidal Rule:  " + str(trapezoidal(a, b, n)))
	print("Simpons Rule:      " + str(simpons(a, b, n)))
	
# Running the methods:
func = raw_input("Type in your function: ")
frm = input("Integrate from: ")
to = input("Integrate to: ")
toString(frm, to, 10000.0)
