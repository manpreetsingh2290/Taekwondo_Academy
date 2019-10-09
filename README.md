# Taekwondo_Academy
Website for Taekwondo instructor to keep track his students, inventory, schedule classes, mark attendance etc.

## STEPS TO RUN THE SYSTEM:
1. Install the oracle database on machine preferably 11g (standard or express edition).
2. Run all the SQL queries from file **DB_Creation_Scripts\Create_User_Schema_Queries.sql** in SYS or SYSTEM user of
database to create the database schema/user DB_OWNER and to grant the appropriate privileges. (SQL developer tool can be used to run SQL queries in database)
3. Then in newly created database user DB_OWNER run the table creation queries file **DB_Creation_Scripts\Create_Tables_Queries.sql**
4. After all the tables and sequences are created in database then run the insert queries file **DB_Creation_Scripts\Insert_Queries.sql** in DB_OWNER database user to insert the seed data.
Note: This will also create a user in database with credentials (username: admin password: admin) which can be used to login to the system.
5. Import project folder (DB_Project) in eclipse.
6. If database server is not on same machine, then change the database server IP in file (**Taekwondo_Academy\src\hibernate.cfg.xml**) of project.
7. Run the project on any web server (preferably Apache tomcat).
8. Open the website in web browser using below link:
http://[Server IP]:[Server Port]/DB_Project/
Example: http://localhost:8081/DB_Project/
9. Login using credentials (admin/admin)
