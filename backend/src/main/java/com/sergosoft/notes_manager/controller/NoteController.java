package com.sergosoft.notes_manager.controller;

import com.sergosoft.notes_manager.dto.NoteDto;
import com.sergosoft.notes_manager.model.NoteEntity;
import com.sergosoft.notes_manager.service.impl.NoteServiceImpl;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/notes")
public class NoteController {

    private final NoteServiceImpl noteService;

    @Autowired
    public NoteController(NoteServiceImpl noteService) {
        this.noteService = noteService;
    }

    @PostMapping
    public ResponseEntity<NoteEntity> createNote(@RequestBody NoteDto noteDto) {
        return ResponseEntity.ok(noteService.saveNote(noteDto));
    }

    @GetMapping
    public ResponseEntity<List<NoteEntity>> getAllNotes() {
        return ResponseEntity.ok(noteService.getAllNotes());
    }

    @GetMapping({"/{id}"})
    public ResponseEntity<NoteEntity> getNoteById(@PathVariable Long id) {
        Optional<NoteEntity> note = noteService.getNoteById(id);
        return note.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<NoteEntity> updateNote(@PathVariable Long id, @RequestBody NoteDto updatedNote) {
        Optional<NoteEntity> existingNote = noteService.getNoteById(id);
        if(existingNote.isPresent()) {
            try {
                return ResponseEntity.ok(noteService.updateNoteById(id, updatedNote));
            } catch (EntityNotFoundException e) {
                return ResponseEntity.notFound().build();
            } catch (Exception e) {
                return ResponseEntity.badRequest().build();
            }
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteNote(@PathVariable Long id) {
        if (noteService.deleteNoteById(id)) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
