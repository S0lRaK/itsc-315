No security manager:
    java MySecurityManager
Default security manager:
    java -Djava.security.manager MySecurityManager
Use security manager with restrictive policy:
    java -Djava.security.manager -Djava.security.policy=security.policy MySecurityManager
Use security manager with less restrictive policy:
    java -Djava.security.manager -Djava.security.policy=security2.policy MySecurityManager

4B Prevent changes involving reflection:
    java -Djava.security.manager PersonReflection
