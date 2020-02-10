1) Move the "input.txt" file to another location outside this directory, e.g. "C:\"

2) Edit the "ReadInputFile.java" file path in the "readdata" subdirectory to point the class at the location of the "input.txt" file and recompile it

2) Edit the "security.policy" file to change the "codeBase" path to point to the location of the directory containing the "UseReadInputFile" class . Also change the "FilePermission" path to point to the location of the "input.txt" file. Save the changes 

3) Run the application using: java -Djava.security.manager -Djava.security.policy=security.policy UseReadInputFile

This should work successfully if the policy file is set correctly.

4) Edit the security.policy file to add "/readdata/" to the end of the "codeBase" path. Save the change and run the application again

This should fail because we are only granting part of the application read access to the file (the code in the "readdata.ReadInputFile" class), and the intersection of permissions being granted to both the "readdata" package and the "UseReadInputFile" class don't allow the application to read the file. Both have to be granted "read" access for the file to be read successfully.


