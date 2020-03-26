#include <stdio.h>
#include <string.h>

int main() {
	char firstName[10];
	char lastName[10];
	char fullName[10];

	printf("First name: ");
	scanf("%s", firstName);

	printf("Last name: ");
	scanf("%s", lastName);

	strcpy(fullName, firstName);
	strcat(fullName, " "); // append a space
	strcat(fullName, lastName);
	
	printf("Full name: %s\n", fullName);

	int occurrences = 0;
	for (int index = 0; index < strlen(fullName); index++)
		if (fullName[index] == 'o') // 'o' = 111 (ASCII)
			occurrences++;

	printf("Number of occurrences of 'o': %d\n", occurrences);
}
