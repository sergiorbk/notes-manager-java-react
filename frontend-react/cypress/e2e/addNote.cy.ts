describe('Add Note Functionality', () => {
  it('Adds a new note to the application', () => {
    cy.visit('http://localhost:3000');

    cy.get('.add-note-button').click();
    cy.get('#title').type('Test Note');
    cy.get('#note').type('This is a test note.');

    cy.get('.add-button').click();

    cy.contains('Test Note').should('exist');
  });
});