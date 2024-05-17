package com.sergosoft.notes_manager.service;

import com.sergosoft.notes_manager.dto.NoteDto;
import com.sergosoft.notes_manager.model.NoteEntity;

import java.util.List;

public interface NoteService {
    List<NoteEntity> getAllNotes();
    NoteEntity saveNote(NoteDto noteDto);
}
