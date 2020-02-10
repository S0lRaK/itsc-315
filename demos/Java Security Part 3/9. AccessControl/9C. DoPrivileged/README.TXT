PURPOSE OF EXERCISE:
--------------------
This exercise shows how we can temporarily escalate permissions in a piece of code so that it can access information that normally it would not be able to, due to it being called by other code that does not have permission to access that value (via the "doPrivileged" method of the AccessController object).


Build Process:
--------------

- Change to "code/TestJar/privclass" directory
- Compile: "javac *.java"
- Change up to ".." from there
- Create "TestJar.jar" file: "jar cf TestJar.jar privclass\*.class"
- Copy "TestJar.jar" file up to "../.." (to the "DoPrivileged" directory)

- Change to "code/UseTestJar/mainclass" directory
- Compile: "javac *.java"
- Change up to ".." from there
- Create UseTestJar.jar file: "jar cmf manifest.mf UseTestJar.jar mainclass\*.class"
- Copy "UseTestJar.jar" file up to "../.." (to the "DoPrivileged" directory)

- Check the settings in the "security.policy" file in "DoPrivileged". Make sure "codeBase" points to the "TestJar.jar" file in your "DoPrivileged" directory (if you want to run the example as initially intended).


Run Process:
------------

-Run the application from a command prompt located in the "DoPrivileged" directory using the command line:

java -Djava.security.manager -Djava.security.policy=security.policy -cp .:./UseTestJar.jar:TestJar.jar mainclass.MainClass


