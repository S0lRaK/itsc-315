Build jar file(s): 
------------------

1) Build single .jar with both classes in it (will be ok)
jar cmf MANIFEST.MF SealedPackage.jar sealedpackage/*.class

2) Build separate .jar files, each with one class in it. Because package is sealed this won't work
jar cmf MANIFEST.MF SealedPackage1.jar sealedpackage/Class1.class
jar cmf MANIFEST.MF SealedPackage2.jar sealedpackage/Class2.class


Run application: 
----------------
Works: java -cp .:./SealedPackage.jar UseSealed

Sealing exception: java -cp .:./SealedPackage1.jar:./SealedPackage2.jar UseSealed







