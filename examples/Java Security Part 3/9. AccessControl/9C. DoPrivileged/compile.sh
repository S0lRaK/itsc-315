#!/bin/sh

cd code/TestJar/privclass
rm *.class
javac *.java
cd ..
rm *.jar
jar cf TestJar.jar privclass/*.class
cp TestJar.jar ../..

cd ../UseTestJar/mainclass
rm *.class
javac -cp .:../../../TestJar.jar *.java
cd ..
rm *.jar
jar cmf manifest.mf UseTestJar.jar mainclass/*.class
cp UseTestJar.jar ../..
cd ../..
