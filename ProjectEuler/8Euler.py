'''
# Author:		Joshua J. Abraham
# Date:			November 2019
# Description:	Largest product in a series.
# Input:		Test file, containing a series of digits.
'''

#TODO: Skip over sequences that contain a zero

## GETTING THE INPUT
input_file = open('8Euler_input.txt')
series = ''

line = input_file.readline().strip()
while(line != ''):
	series = series + line
	line = input_file.readline().strip()


## DOING THE CALCULATION
index = 0
max = 0

while(index + 13 <= len(series)):
	prod = eval("*".join(series[index : index + 13]))
	if(prod > max):
		max = prod
	
	index = index + 1

print(max)