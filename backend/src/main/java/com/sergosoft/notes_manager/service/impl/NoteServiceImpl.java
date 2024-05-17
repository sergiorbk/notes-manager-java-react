package com.sergosoft.notes_manager.service.impl;

import com.sergosoft.notes_manager.dto.NoteDto;
import com.sergosoft.notes_manager.model.NoteEntity;
import com.sergosoft.notes_manager.repository.NoteRepository;
import com.sergosoft.notes_manager.service.NoteService;
import com.sergosoft.notes_manager.transformer.NoteTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NoteServiceImpl implements NoteService {

    private final NoteRepository noteRepository;
    private final NoteTransformer noteTransformer;

    @Autowired
    public NoteServiceImpl(NoteRepository noteRepository) {
        this.noteRepository = noteRepository;
        noteTransformer = new NoteTransformer();
    }

    @Override
    public List<NoteEntity> getAllNotes() {
        return noteRepository.findAll();
    }

    @Override
    public NoteEntity saveNote(NoteDto noteDto) {
        return noteRepository.save(noteTransformer.toEntity(noteDto));
    }

    @Override
    public Optional<NoteEntity> getNoteById(Long id) {
        return noteRepository.findById(id);
    }

    @Override
    public boolean deleteNoteById(Long id) {
        if(noteRepository.existsById(id)) {
            noteRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }
}
