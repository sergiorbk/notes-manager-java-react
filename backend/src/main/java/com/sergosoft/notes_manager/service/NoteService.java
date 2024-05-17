package com.sergosoft.notes_manager.service;

import com.sergosoft.notes_manager.dto.NoteDto;
import com.sergosoft.notes_manager.model.NoteEntity;

import java.util.List;
import java.util.Optional;

public interface NoteService {
    List<NoteEntity> getAllNotes();
    NoteEntity saveNote(NoteDto noteDto);
    Optional<NoteEntity> getNoteById(Long id);
    boolean deleteNoteById(Long id);
}
