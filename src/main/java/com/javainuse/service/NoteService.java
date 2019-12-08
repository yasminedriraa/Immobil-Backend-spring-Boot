package com.javainuse.service;


import com.javainuse.model.Note;

import java.util.List;


public interface NoteService {
    Note createNote(Note note);
    List<Note> getAllNotes();
    Note getNoteById(Long id);
    Note updateNote( Note note) throws Exception;
    List<Note> getNotesByUserID(Long userId);
    List<Note> getNotesByAnnonceId(Long annonceId);
    void deleteNote(Long id);
}
