# Client Application of the Notes Manager (React)

This is the client-side application for the Notes Manager, built using React. Follow the instructions below to set up and run the application on your local machine.

## Prerequisites

Make sure you have the following software installed on your system:

- Node.js (v20.13.1 or later, download [here](https://nodejs.org/en)) 
- npm (v10.8.0 or later, installed with Node.js)

## Getting Started
1. Run the server-side application (see the guide in the [backend folder](../backend/README.md)).
2. Open your command line interface (CLI) and navigate to the 'frontend-react' folder of your project using the following command:
3. Initialize npm and install dependencies by running the command: `npm install`
4. To start your client application, run the command: `npm run start`
This will launch the development server for your React application.
5. Open your web browser and navigate to http://localhost:3000 to view your running React application.

## Testing (e2e)
1. Open command line and open frontend-react folder: `cd frontend-react`
2. Make shure that Node.js and npm are installed
3. Install Cypress dependencies:  `npm install cypress --save-dev`
4. Run Cypress application: `npx cypress open`
5. Make shure that server-side and client-side applications are working
6. Use application to run available tests (e2e - > addNote.cy: http://localhost:3000/__/#/specs/runner?file=cypress/e2e/addNote.cy.ts)

