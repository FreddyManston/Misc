#Largest prime factor of 600851475143

Primes = [2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31]
Next_Prime = 37

while (Next_Prime <= (600851475143 ** 0.5) + 1):
	isPrime = True
	for i in Primes:
		if (Next_Prime % i == 0):
			isPrime = False
			break
	if (isPrime):
		Primes.append(Next_Prime)
	Next_Prime += 2
	print Next_Prime
print Primes

count = 1
while (count < len(Primes)):
	if (600851475143 % Primes[len(Primes) - count] == 0):	# From last to first in Primes list
		break
	count += 1
print Primes[len(Primes) - count]
