# Simple Library Management System
This is a library management system built with Spring Boot, featuring REST APIs for library-related functionalities.

## Tech Stack
- Java 23
- Spring Boot
- Spring Data JPA
- H2 Database
- Gradle

## Using Library Management System
```
git clone https://github.com/willystw/library-system.git
cd library-system
./gradlew build
java -jar build/libs/library-system-0.0.1-SNAPSHOT.jar
```

## Assumption Used in The System
- Each book has a single copy
- Each checkout record corresponds to a single book