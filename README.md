# Covid Vaccines Manager
![Covid_Vaccines_Manager_bckg](https://user-images.githubusercontent.com/44868857/152211554-3356ad7c-16a6-4e27-b91d-9e7efdccc944.png)

## Introduction
This project is a desktop application, which aims to help health care centers against Covid-19 in the management of their materials, ie masks, gloves, medical gowns, gels and vaccines. Moreover, the application allows to register the vaccination of a person and to increment the number of doses received by this person during these different vaccinations.
The application also has a visual representation of the current stock and completed vaccinations in the form of two pie charts.

## Video
![demo](https://user-images.githubusercontent.com/44868857/152213940-43fea471-0549-48e3-91de-c555b5c20411.gif)

## Team
### Project Supervisor:
- Karim Hammoudi, Université de Haute-Alsace, IRIMAS, karim.hammoudi@uha.fr

### Project Developers:
- Benoît De Sousa ([github](https://github.com/desousar)), Université de Haute-Alsace, M1 IM, benoitdesousa@gmail.com 
- Yassine Ben Fekih ([github](https://github.com/ybf34)), Université de Haute-Alsace, M1 IM, ybenfekih@gmail.com

### Conceptors:
- Safia Saci, Université de Haute-Alsace, M1 IM
- Nathan Dahy, Université de Haute-Alsace, M1 IM

### Contributors:
-	Tassadit Boutata
-	Adnan Mustafic
-	Julien Bianchetti
-	Lukas Folcher
-	Mathieu Meyer
-	Saad Ansari

## Installation
The easiest way is to download WAMP, MAMP or LAMP to have a database administered by phpMyAdmin.
Clone the directory and import the DBinit.sql file (database structure) into phpMyAdmin. The file is designed to create its own database and tables.
Open the program on Eclipse (for example) and go to the file GlobalDAO.java to modify the name, the password and the port corresponding to your SQL server.

Note that the application is blocked by an authentication. A user exists by default (toto,toto). To add your user, you just must add manually in the SQL table 'auth' a name and a password hashed in MD5 (the hash function is available in the MainWindows.java class to get the result).

## Acknowledgements
The authors would like to thank:
- Vincent Seyller ([portfolio](https://seyller-vincent.com/)), a Master's student, for the creation of the application's logo.
  
  
## Application's context
Project done in the context of the course "Agile Methods" of the M1 IM/MIAGE of the University of Haute-Alsace.
The goal was to develop a working desktop application.
The application was developped in one sprint of 2 weeks including stages of design, development and tests through an agile development cycle.
 
 
