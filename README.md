# JDBC
TASK DESCRIPTION:
Create BD with tables: developers and skills. Each developer can has many skills.
Create console application. The application must read, modify, delete and add data to the DB.

Technologies:
- Java
- JDBC
- MySQL

HOW TO RUN APPLICATION:
1) Download and install mySQL server v. 5.7.16 e.g. from here http://dev.mysql.com/downloads/installer/;
2) Create DB "test" with "DEVELOPER","SKILLS" and "DEV_SKILLS" tables (or you can create them via application
throws selecting point "Update\Insert\Delete information in the DB" in the menu);*
3) Download Connector/J v. 5.0.8 zip, binary distribution
e.g from here https://dev.mysql.com/downloads/connector/j/5.0.html;
4) Unpack the .zip and add JDBC Driver (mysql-connector-java-5.0.8-bin.jar) location to the java CLASSPATH
(IDEA sometime ignored CLASSPATH as environment variable, so you can add directly .jar to the project:
go to IDEA, Project Setting Ctr+Alt+Shift+S,choose Modules from Project Settings,
go to Dependencies tab, click "Add JARs or Directories" mark and choose the .jar, click "Ok" button);
5)Run "Runner" class to be able execute you SQL queries.

*SQL queries to create necessary tables:
CREATE TABLE IF NOT EXISTS developers (
	id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
	dev_name VARCHAR(25) NOT NULL,
	dev_surname VARCHAR(35) NOT NULL
);
CREATE TABLE IF NOT EXISTS skills (
	id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
	skills_name VARCHAR(25) NOT NULL
);
CREATE TABLE IF NOT EXISTS dev_skills (
	dev_skills_id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
	developers_id INT,
	skills_id INT,
	UNIQUE (developers_id, skills_id),
	FOREIGN KEY (developers_id) REFERENCES developers (id) ON UPDATE RESTRICT
	ON DELETE CASCADE,
	FOREIGN KEY (skills_id) REFERENCES skills (id) ON UPDATE RESTRICT
	ON DELETE CASCADE
);