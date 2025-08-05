# Install
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