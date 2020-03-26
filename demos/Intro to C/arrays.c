#include <stdio.h>

int main() {
	int a[4] = {2,4,6,8};
	int b[10]; // uninitialized

	printf("Address of a: %x\n", a);
	printf("Address of first element of a with []: %d\n", a[0]);
	printf("Address of first element of a with *: %d\n", *a);
	printf("Second element of a: %d\n", a[1]);
	printf("Second element of a: %d\n", *(a + 1));
	printf("Address of second element: %x\n", &(*(a + 1)));
	printf("Address of second element: %x\n", (a + 1));

	a[1] = 'A';
	printf("Second element of a as digit: %d\n", a[1]);
	printf("Second element of a as char: %c\n", a[1]);
}
