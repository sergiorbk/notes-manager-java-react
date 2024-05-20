import React, { useEffect, useState } from 'react';
import axios from 'axios';
import AddNoteForm from './AddNoteForm';
import EditNoteForm from './EditNoteForm';
import '../styles/NoteList.scss';
import {useTranslation} from "react-i18next";

export function NoteList() {
    const [notes, setNotes] = useState([]);
    const [loading, setLoading] = useState(true);
    const [error, setError] = useState(null);
    const [showAddForm, setShowAddForm] = useState(false);
    const [editingNote, setEditingNote] = useState(null);

    const { t } = useTranslation();

    useEffect(() => {
        fetchNotes();
    }, []);

    const fetchNotes = () => {
        setLoading(true);
        axios.get('http://localhost:8080/notes')
            .then(response => {
                setNotes(response.data);
                setLoading(false);
            })
            .catch(error => {
                console.error('Error fetching data:', error);
                setError('Error fetching data');
                setLoading(false);
            });
    };

    const handleDelete = (id) => {
        axios.delete(`http://localhost:8080/notes/${id}`)
            .then(() => {
                setNotes(notes.filter(note => note.id !== id));
            })
            .catch(error => {
                console.error('Error deleting note:', error);
                setError('Error deleting note');
            });
    };

    const handleAdd = (newNote) => {
        axios.post('http://localhost:8080/notes', newNote)
            .then(response => {
                setNotes([...notes, response.data]);
                setShowAddForm(false);
            })
            .catch(error => {
                console.error('Error adding note:', error);
                setError('Error adding note');
            });
    };

    const handleEdit = (updatedNote) => {
        axios.put(`http://localhost:8080/notes/${updatedNote.id}`, updatedNote)
            .then(response => {
                setNotes(notes.map(note => (note.id === updatedNote.id ? response.data : note)));
                setEditingNote(null);
            })
            .catch(error => {
                console.error('Error updating note:', error);
                setError('Error updating note');
            });
    };

    if (loading) {
        return <p>{t('loading')}</p>;
    }

    if (error) {
        return <p>{error}</p>;
    }

    return (
        <div className="note-list-container">
            <h1>{t('noteListTitle')}</h1>
            <div className="table-container">
                <table className="note-table">
                    <thead>
                    <tr>
                        <th>ID</th>
                        <th>{t('title')}</th>
                        <th>{t('note')}</th>
                        <th>{t('actions')}</th>
                    </tr>
                    </thead>
                    <tbody>
                    {notes.map(note => (
                        <tr key={note.id}>
                            <td>{note.id}</td>
                            <td>{note.title}</td>
                            <td>{note.note}</td>
                            <td>
                                <button onClick={() => setEditingNote(note)}>{t('change')}</button>
                                <button onClick={() => handleDelete(note.id)}>{t('delete')}</button>
                            </td>
                        </tr>
                    ))}
                    </tbody>
                </table>
            </div>
            <div className="button-panel">
                <button onClick={fetchNotes}>{t('update')}</button>
                <button className="add-note-button" onClick={() => setShowAddForm(true)}>{t('add')}</button>
            </div>
            {showAddForm && (
                <AddNoteForm
                    onAdd={handleAdd}
                    onCancel={() => setShowAddForm(false)}
                />
            )}
            {editingNote && (
                <EditNoteForm
                    note={editingNote}
                    onEdit={handleEdit}
                    onCancel={() => setEditingNote(null)}
                />
            )}
        </div>
    );
}
