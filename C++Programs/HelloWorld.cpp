#include <iostream>

using namespace std;

/*
	main() method always executed first.
	int implies integer is returned (for main(), default of 0 returned)
	cout ('C-OUT') is output
	cin ('C-IN') is input from user
*/
int main() {
	int num;

	cout<<"Enter a number: ";
	cin>> num;
	cin.ignore();
	cout<<"You've entered: "<< num <<"\n";
	cin.get();
}
