# AddressBook Coding Challenge

This repository contains the code for the Address Book Coding Challenge. Τhe application implemented an Address Book that allows
a user to store (between successive runs of the program) the name and phone numbers of their friends, with the following functionality:
- To enter a friends name and phone number using a form with input validation (backend).
- To display the list of friends and their corresponding phone numbers sorted by their name.


### Assumptions:
- "AddressBook" table is initialised from "Contant" entity in Spring Boot backend.
- Databse is seeded with 7 initial contacts.

# Architecture & Usage

### Database - PostgreSQL

A PostgreSQL database is used for this application. In order to connect to the database PostgreSQL must be running on port 542.
Database connection configurations can be changed in file: `address-book\src\main\resources\application.properties`

Compulsary changes to connect to db:
`
- spring.datasource.url=jdbc:postgresql://localhost:5432/[DATABASE_NAME]
- spring.datasource.username=[USERNAME]
- spring.datasource.password=[PASSWORD]
`

### Java (Spring Boot) - Backend

The backend for this application was implemented using Spring Boot. A layered architecture was used based around the "Contact" Model.
To start the back end, first run `mvn install` then `mvn spring-boot:run` or `java -jar target/address-book-0.0.1.jar` to start the dev server on port 8080.

## REST ENDPOINTS:

GET: Get all contacts from database
- `http://localhost:8080/api/v1/contact/getAll`

GET: Get unique contacts - not implemented due to time constraints
- `http://localhost:8080/api/v1/contact/getUniqueContacts`

POST: Add a new Contact to database
- `http://localhost:8080/api/v1/contact/add`

##### Payload:
`{
	"firstName": "Fred",
	"lastName": "Jones",
	"phoneNumber":  "0412345678" 
}`

### React - Frontend

The frontend was developed using ReactJS. It features a single page view for the Address Book with a UI component to display all contacts.
There is a button which displays a modal with a form to add a new contact.
To deploy the front end, first run `npm install` to install dependencies then `npm start` to start the dev server on port 3000.
