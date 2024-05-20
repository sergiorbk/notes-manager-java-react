import React, {useState} from 'react';
import '../styles/AddNoteForm.scss';
import {useTranslation} from "react-i18next";

const AddNoteForm = ({ onAdd, onCancel }) => {
    const { t } = useTranslation();
    const [title, setTitle] = useState('');
    const [note, setNote] = useState('');

    const handleSubmit = (e) => {
        e.preventDefault();
        if (title && note) {
            onAdd({ title, note });
            setTitle('');
            setNote('');
        }
    };

    return (
        <div className="add-note-form-container">
            <form className="add-note-form" onSubmit={handleSubmit}>
                <h2>{t('addNewNote')}</h2>
                <div className="form-group">
                    <label htmlFor="title">{t('title')}</label>
                    <input
                        type="text"
                        id="title"
                        value={title}
                        onChange={(e) => setTitle(e.target.value)}
                        required
                    />
                </div>
                <div className="form-group">
                    <label htmlFor="note">{t('note')}</label>
                    <textarea
                        id="note"
                        value={note}
                        onChange={(e) => setNote(e.target.value)}
                        required
                    ></textarea>
                </div>
                <div className="form-buttons">
                    <button type="submit" className="add-button">{t('add')}</button>
                    <button type="button" className="cancel-button" onClick={onCancel}>{t('cancel')}</button>
                </div>
            </form>
        </div>
    );
};

export default AddNoteForm;
