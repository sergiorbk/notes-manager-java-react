package com.sergosoft.notes_manager.repository;

import com.sergosoft.notes_manager.model.NoteEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NoteRepository extends JpaRepository<NoteEntity, Long> {

}
