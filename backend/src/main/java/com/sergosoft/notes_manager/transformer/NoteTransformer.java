package com.sergosoft.notes_manager.transformer;

import com.sergosoft.notes_manager.dto.NoteDto;
import com.sergosoft.notes_manager.model.NoteEntity;

public class NoteTransformer {
    public NoteDto toDto(NoteEntity noteEntity) {
        return new NoteDto(noteEntity.getTitle(), noteEntity.getNote());
    }

    public NoteEntity toEntity(NoteDto noteDto) {
        return new NoteEntity.Builder()
                .setTitle(noteDto.getTitle())
                .setNote(noteDto.getNote())
                .build();
    }
}
