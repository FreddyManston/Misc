# Sum of the even numbers of the Fibonacci sequence from 1 - 4 000 000
Prev = 1
Curr = 2
Fib_Sum = 0

while (Curr <= 4000000):
	if (Curr % 2 == 0):
		Fib_Sum += Curr
	temp = Curr
	Curr += Prev
	Prev = temp
print Fib_Sum
