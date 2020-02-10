No security manager:
    java CheckCreateClassLoader
Default security manager:
    java -Djava.security.manager CheckCreateClassLoader
Use security manager with restrictive policy:
    java -Djava.security.manager -Djava.security.policy=security.policy CheckCreateClassLoader
