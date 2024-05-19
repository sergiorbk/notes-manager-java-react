import React from 'react';
import { NoteList } from './components/NoteList';
import './styles/App.scss';
import { useTranslation } from "react-i18next";

function App() {
    const { t } = useTranslation();

    return (
        <div className="app-container">
            <h1>{t('appName')}</h1>
            <NoteList />
        </div>
    );
}

export default App;