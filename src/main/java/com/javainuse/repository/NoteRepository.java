package com.javainuse.repository;

import com.javainuse.model.Note;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface NoteRepository extends JpaRepository<Note, Long> {
    List<Note> getNoteByUserId(Long userId);
    List<Note> getNotesByAnnonceId(Long annonceId);
}
