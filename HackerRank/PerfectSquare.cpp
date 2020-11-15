/* Author: Joshua J. Abraham
** Date: Decemebr 2018
** Description: Checks if a given number n is a perfect square or not
**		Uses the sum of odd numbers method
**		Link: https://www.hackerrank.com/contests/learn-more/challenges/find-square-numbers
*/

#include <iostream>
#include <sstream>

bool isSquare(int n) {
	int sum = 0;
	int count = 1;
	
	while(sum < n) {
		sum += count;
		count += 2;
	}

	if(sum == n) { return true; }
	else { return false; }
}

int main(int argc, char const *argv[]) {
	std::stringstream str_num;
	str_num << argv[1];
	int int_num;
	str_num >> int_num;

	int is_square = isSquare(int_num);
	if(is_square == 1) { std::cout << int_num << " is a perfect square.\n"; }
	else { std::cout << int_num << " is not a perfect square. \n"; }

	return 1;
}
