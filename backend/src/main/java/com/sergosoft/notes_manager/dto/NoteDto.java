package com.sergosoft.notes_manager.dto;

public class NoteDto {

    private final String title;
    private final String note;

    public NoteDto(String title, String note) {
        this.title = title;
        this.note = note;
    }

    public String getTitle() {
        return title;
    }

    public String getNote() {
        return note;
    }
}
