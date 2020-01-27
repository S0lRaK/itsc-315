cd code\TestJar\privclass
del *.class
javac *.java
cd ..
del *.jar
jar cf TestJar.jar privclass\*.class
copy TestJar.jar ..\..

cd ..\UseTestJar\mainclass
del *.class
javac -cp .;..\..\..\TestJar.jar *.java
cd ..
del *.jar
jar cmf manifest.mf UseTestJar.jar mainclass\*.class
copy UseTestJar.jar ..\..
cd ..\..
