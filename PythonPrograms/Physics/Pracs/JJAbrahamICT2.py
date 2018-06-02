# Name: Joshua Abraham
# Student number: 3475896

from visual.graph import*

def ICT2a():
    x = int(input("Please enter the first number: "))
    y = int(input("Please enter the second number: "))
    z = int(input("Please enter the third number: "))

    # Algorithm puts the 3 numbers into a list, then sorts the list in
    # ascending order. After that it prints out the last element in the list.
    num_list = [x, y, z]    # A list containing the 3 numbers
    num_list.sort()     # Sorting the list

    # The following line prints out the last element in the list
    print ("The largest value entered was: " + str(num_list[len(num_list) - 1]))

def f(x):
    return 2 * x ** 2 + 3 * x + 4   # Returns the value of x when x is put in the given function

def f_prime(x):
    return 4 * x + 3    # Returns the value of x when x is put in the derivative

def ICT2c():
    funct = gcurve(color = color.blue)
    deriv = gcurve(color = color.red)

    # For loop runs through every number from 0 - 7 in increments of 0.125
    for x in arange(0.0, 7.001, 0.125):
        funct.plot(pos = (x, f(x)))     # Plots a point x for all x values given from the for loop
        deriv.plot(pos = (x, f_prime(x)))   # Plots a point x for all x values given from the for loop

ICT2a()
ICT2c()
