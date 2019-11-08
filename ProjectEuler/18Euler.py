'''
# Author:	Joshua J. Abraham
# Date		December 2018
# Description:	Maximum Path Sum 1.
#		Given a triangle of numbers, find the largest path from the bottom to the top.
# Input:		Text file containing the triangle, upside down
'''


## GETTING THE INPUT
input_file = open('67Euler_input.txt')
line = [int(x) if x != '' else '' for x in input_file.readline().strip().split(' ')]
triangle = []
while(line != ['']):
	triangle.append(line)
	line = [int(x) if x != '' else '' for x in input_file.readline().strip().split(' ')]

## DOING THE CALCULATION
for row in range(1, len(triangle)):
	for i in range(0, len(triangle[row])):
		triangle[row][i] = triangle[row][i] + max(triangle[row-1][i], triangle[row-1][i+1])

print "Max Sum Total = " + str(triangle[len(triangle) - 1][0])
