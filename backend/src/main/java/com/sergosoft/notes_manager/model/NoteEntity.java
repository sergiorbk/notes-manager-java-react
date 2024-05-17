package com.sergosoft.notes_manager.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import org.springframework.lang.NonNull;

@Entity(name = "notifications")
public class NoteEntity {

    private NoteEntity(Builder builder) {
        this.title = builder.title;
        this.note = builder.note;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NonNull
    private String title;

    @NonNull
    private String note;

    public NoteEntity() {}

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    @NonNull
    public String getTitle() {
        return title;
    }

    public void setTitle(@NonNull String title) {
        this.title = title;
    }

    @NonNull
    public String getNote() {
        return note;
    }

    public void setNote(@NonNull String note) {
        this.note = note;
    }

    public static class Builder {
        private String title;
        private String note;

        public Builder setTitle(String title) {
            this.title = title;
            return this;
        }

        public Builder setNote(String note) {
            this.note = note;
            return this;
        }

        public NoteEntity build() {
            return new NoteEntity(this);
        }
    }
}
