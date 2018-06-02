#include <stdio.h>

/*
	main() method executed first. int implies that an integer is returned by the method
	omit int if nothing is returned.
	getchar() reads a char input from user.
*/
int main() {
	char *a = "Hello World";
	float fnum = 0.324;
	printf("%f\n",fnum);
	printf("%c\n",a);
	return 0;
}