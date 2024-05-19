import React from 'react';
import { NoteList } from './components/NoteList';
import './styles/App.scss';

function App() {
  return (
      <div className="app-container">
          <h1>Note Manager</h1>
          <NoteList/>
      </div>
  );
}

export default App;
