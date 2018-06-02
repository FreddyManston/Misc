# Sum of the multiples of  3 & 5 between 0 - 1000
Three_Sum = 3
Five_Sum = 5
Counter = 2

while (Counter * 3 < 1000):
	Three_Sum += Counter * 3
	Counter += 1
Counter = 2
while (Counter * 5 < 1000):
	if ((Counter * 5) % 3 != 0):
		Five_Sum += Counter * 5
	Counter += 1
print Three_Sum + Five_Sum
