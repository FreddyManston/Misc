# Checks if a given number n is a perfect square or not
# Uses the sum of odd numbers method

n = 484 # number to check

sum = 0
count = 1
while(sum < n):
	sum = sum + count
	count = count + 2

print(sum)
if(sum == n):
	print("{:d} is a perfect square.".format(n))
else:
	print("{:d} is not a perfect square.".format(n))
