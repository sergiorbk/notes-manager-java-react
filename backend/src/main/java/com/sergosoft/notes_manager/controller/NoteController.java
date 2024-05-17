package com.sergosoft.notes_manager.controller;

import com.sergosoft.notes_manager.dto.NoteDto;
import com.sergosoft.notes_manager.model.NoteEntity;
import com.sergosoft.notes_manager.service.impl.NoteServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/notes")
public class NoteController {

    private final NoteServiceImpl noteService;

    @Autowired
    public NoteController(NoteServiceImpl noteService) {
        this.noteService = noteService;
    }

    @GetMapping
    public ResponseEntity<List<NoteEntity>> getAllNotes() {
        return ResponseEntity.ok(noteService.getAllNotes());
    }

    @PostMapping
    public ResponseEntity<NoteEntity> createNote(@RequestBody NoteDto noteDto) {
        return ResponseEntity.ok(noteService.saveNote(noteDto));
    }
}
