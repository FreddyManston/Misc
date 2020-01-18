# Special Pythagorean triplet

import time

## Brute force method:
start_time = time.time()
for a in range(500):
	for b in range(500):
		if (a**2 + b**2 == (1000 - a - b)**2):
			prod = a * b * (1000 - a -b)
			end_time = time.time()
			break

brute_time = end_time - start_time


## Euclid's formula method:
# (a = m^2 - n^2, b = 2*m*n, c = m^2 + n^2)
start_time = time.time()
for m in range(25):
	for n in range(25):
		a = m**2 - n**2
		b = 2*m*n
		c = m**2 + n**2
		if (a**2 + b**2 == c**2) and (a+b+c == 1000):
			product = a*b*c
			end_time = time.time()

eulers_time = end_time - start_time


print("Product = %d" %(prod))
print("Pythagorean triplet was found in %5f secs with brute force vs %5f with euler's method." %(brute_time, eulers_time))