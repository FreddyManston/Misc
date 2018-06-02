#include <stdio.h>

int main() {
	int sqr_of_sum = 0, sum_of_sqrs = 0;

	for (int i = 1; i <= 100; i += 1) {
		sqr_of_sum += i;
		sum_of_sqrs += i * i;
	}
	printf("Difference is: %d - %d = %d\n", (sqr_of_sum*sqr_of_sum), sum_of_sqrs, (sqr_of_sum*sqr_of_sum - sum_of_sqrs));

	return 0;
}