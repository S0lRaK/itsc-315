#include <stdio.h>
#include <stdlib.h>

int main() {

	printf("Name: ");
	char* name = (char *)malloc(20);
	scanf("%s", name);

	printf("Age: ");
	int* age = (int *)malloc(sizeof(int)); // sizeof(int) = 4
	scanf("%d", age);

	printf("%s is %d years old.\n", name, *age);
	free(name);
	free(age);
}
