#Author: Josh
#Name: Times Tables
#Details: Gives the person the times table of their choice, up to a number of their choice.

times = int(input("What number are we going to count in: "))
towhat = int(input("Till what number are we going to count: "))

num = times
index = 1
print("\nThis is the times table of %s: \n---------------------------------") % (times)

while (num <= towhat):
	print ("%s x %s = %s") % (index, times, num)
	num = int(num) + int(times)
	index = int(index) + 1

check = num - times

if (check == towhat):
	print ("\nThat's the %s times table, up until %s.") % (times, towhat)
else:
	print ("\n%s is not in the %s times table.") % (towhat, times)

amount = check // int(times)
print ("There are %s numbers in this set.\n") % (amount)