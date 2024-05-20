# Server Application of the Notes Manager (Java)

This is the server-side application for the Notes Manager, built using Java and Spring Boot. Follow the instructions below to set up and run the application on your local machine.

## Prerequisites

Make sure you have the following software installed on your system:

- Java Development Kit (JDK) 20 or later
- Apache Maven 3.9.6 or later

## Getting Started
1. Open a terminal and navigate to the "backend" directory.
2. Use Maven to build the project: `mvn clean install`
3. Change directory to the "target" folder: `cd target`
4. Run the application: `java -jar notes-manager-1.0.0.jar`

## API endpoints (http://localhost:8080/)
* GET /notes (get all notes)
* GET /notes/{id} (get specified note)
* POST /notes (create note)
* PUT /notes/{id} (update note)
* DELETE /notes/{id} (delete note)
