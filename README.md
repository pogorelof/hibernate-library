# Library Management System (Hibernate Study Project)
## Stack
* Java 17+
* Hibernate 7
* Postgresql
* Gradle 

## Functional
1. Add a new author
2. Add a new book (with author selection)
3. Register a new reader
4. Lend a book to a reader
5. Return a book from a reader
6. View a list of all books with availability information
7. View all books borrowed by a specific reader
8. Delete a book
9. Delete a reader

## Configuration
1. Make .env file in src/main/resources
2. Create keys
```
DB_USERNAME=
DB_PASSWORD=
DB_URL=
```
*  You don't have to specify **DB_PASSWORD** if you don't have a password
* DB_URL - jdbc:postgresql://*host*:*port*/*database_name*
3. Use *init.sql* in core directory for initialization sql tables and test data.

## Build and Run
```bash
./gradlew build 
./gradlew run --console=plain
```