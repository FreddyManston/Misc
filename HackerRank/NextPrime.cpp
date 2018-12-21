/* Author: Joshua J. Abraham
** Date: Decemebr 2018
** Description: Given a number, finds the next consecutive prime number using the Sieve of Eratosthenes method
*/

#include <stdlib.h>
#include <iostream>
#include <sstream>
#include <math.h>

// In:	an integer
// Out:	an array of non-zero primes up to the given integer
int* sieveOfEratosthenes(int num) {
	// Filling up the array
	num -= 1;	// accounting for the array starting at 2 instead of 1
	int* primes;
	primes = (int*) malloc(num * sizeof(int));
	for(int i = 0; i < num; i++) {
		primes[i] = i + 2;	// start array from 2 instead of 1
	}
	
	// Sieving out the array
	for(int i = 0; i < sqrt(num); i++) {
		if(primes[i] == 0) {
			continue;	// skip if it's been marked as composite
		}
		else {
			// remove all multiples of the sieve
			for(int j = pow(i+2, 2) - 2; j < num; j++) {
				if(primes[j] % primes[i] == 0) {
					primes[j] = 0;
				}
			}
		}
	}
	
	// Printing out the array
	std::cout << "\nThe initial array of primes is: \n[";
	for(int i = 0; i < num; i ++) {
		std::cout << primes[i] << ", \t";
		if((i+1)%18 == 0) {
			std::cout << "\n";
		}
	}
	std::cout <<"]\n\n";

	return primes;
}

// In:	A starting array of non-zero primes + the size of the array
// Out:	The next consecutive prime not in the array
int findNextPrime(int* p, int size) {
	size -= 1;	// accounting for primes array starting at 2 instead of 1
	bool found = false;
	int next_prime = size + 1;	// number at which to start the search 
	while(!found) {
		next_prime ++;
		found = true;	// assume next_prime is a prime
		for(int i = 0; i < size; i++) {
			//std::cout << "next prime: " << next_prime << "\n*(p + i): " << *(p + 1) << "\n\n";
			if(*(p + i) == 0) {	// account for a prime array like: [2, 3, 0, 5, 0, 7, 0, 0, 0, 11, ....]
				continue;
			}
			else if(next_prime % *(p + i) == 0) {	// if a divisor is found
				found = false;
				break;
			}
		}
	}
	
	return next_prime;
}

int main(int argc, char const *argv[]) {
	std::stringstream str_num;
	str_num << argv[1];
	int int_num;
	str_num >> int_num;
	
	int* p;
	p = sieveOfEratosthenes(int_num);
	std::cout << findNextPrime(p, int_num) << "\n";
}
