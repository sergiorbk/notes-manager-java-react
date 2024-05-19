import React, { useState } from 'react';
import { useTranslation } from 'react-i18next';
import '../styles/EditNoteForm.scss';

const EditNoteForm = ({ note, onEdit, onCancel }) => {
    const { t} = useTranslation();
    const [title, setTitle] = useState(note.title);
    const [noteContent, setNoteContent] = useState(note.note);

    const handleSubmit = (e) => {
        e.preventDefault();
        if (title && noteContent) {
            onEdit({ ...note, title, note: noteContent });
        }
    };

    return (
        <div className="edit-note-form-container">
            <form className="edit-note-form" onSubmit={handleSubmit}>
                <h2>{t('editNote')}</h2>
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
                        value={noteContent}
                        onChange={(e) => setNoteContent(e.target.value)}
                        required
                    ></textarea>
                </div>
                <div className="form-buttons">
                    <button type="submit" className="edit-button">{t('save')}</button>
                    <button type="button" className="cancel-button" onClick={onCancel}>{t('cancel')}</button>
                </div>
            </form>
        </div>
    );
};

export default EditNoteForm;
