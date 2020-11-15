/* Author:	Joshua J. Abraham
** Date:	November 2020
** Description:
		Given a decimal integer, convert to 32-bit binary and flips the bits.
		Link: https://www.hackerrank.com/challenges/flipping-bits/problem?utm_campaign=challenge-recommendation&utm_medium=email&utm_source=7-day-campaign
*/

#include <iostream>
#include <iterator>
#include <sstream>
#include <cmath>
//#include <bits/stdc++.h>

using namespace std;

// Get the 32-bit binary.
string decimalTo32BitBinary(long n)
{
	string bin32 = "00000000000000000000000000000000";
	
	cout << "Before: " << bin32 << endl;
	for (int pos = 31; pos >= 0 && n > 0; pos--)
	{
		cout << "Position: " << pos << "\tN: " << n << endl;
		if(n % 2 != 0)
		{
			bin32[pos] = '1';
		}
		n /= 2;
	}
	cout << "After: " << bin32 << endl;
	
	return bin32;
}

// Get the decimal.
long BinaryToDecimal(string n)
{
	long dec = 0;
	for (int pos = 31; pos >= 0> 0; pos--)
	{
		if(n[pos] == '1')
		{
			cout << "HERE" << endl;
			dec = dec + (pow(2, 31 - pos));
		}
	}
	
	return dec;
}

// Flip the bits.
long flippingBits(long n) {
	string n_bin = decimalTo32BitBinary(n);
	
	for(int i = 0; i < n_bin.length(); i++)
	{
		if(n_bin[i] == '0')
		{
			n_bin.replace(i, 1, "1");
		}
		else
		{
			n_bin.replace(i, 1, "0");
		}
	}
	
	return BinaryToDecimal(n_bin);
}

// Flip the bits in an optimised manner.
long flippingBitsOptimised(long n) {
	// n XOR (4294967295)base10 = (11111111111111111111111111111111)base2
	return n ^ 4294967295;
}

int main()
{
	int decimal_val;
	cout << "Enter the decimal value: ";
	cin >> decimal_val;
	
	long result = flippingBitsOptimised(decimal_val);
	cout << "Result: " << result << endl;
}
