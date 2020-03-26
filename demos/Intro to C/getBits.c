#include <stdio.h>

unsigned getBits(unsigned x, int p, int n) {
	x = x >> (p - n + 1); // shift right (p - n + 1) times
	unsigned mask = ~(~0 << n); // create a mask to include only the required bits
	x = x & mask;
	return x;
}

int main() {
	unsigned x = 0x99;
	unsigned result = getBits(x, 4, 3);
	printf("%x", result);
}
