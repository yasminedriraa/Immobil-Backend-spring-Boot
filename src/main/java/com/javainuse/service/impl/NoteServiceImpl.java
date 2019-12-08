package com.javainuse.service.impl;

import com.javainuse.model.Note;
import com.javainuse.repository.NoteRepository;
import com.javainuse.service.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NoteServiceImpl implements NoteService {

    @Autowired
    private NoteRepository noteRepository;

    @Override
    public Note createNote(Note note) {
        return noteRepository.save(note);
    }

    @Override
    public List<Note> getAllNotes() {
        return noteRepository.findAll();
    }

    @Override
    public Note getNoteById(Long id) {
        return noteRepository.findById(id).get();
    }

    @Override
    public Note updateNote( Note note) throws Exception{
        if (note.getId() == null) {
            throw new Exception("Note must have an id");
        }
        Note noteToUpdate = noteRepository.findById(note.getId()).get();
        if (noteToUpdate != null) {
            noteToUpdate.setId(note.getId());
            noteToUpdate.setTitle(note.getTitle());
            noteToUpdate.setContent(note.getContent());
            noteToUpdate.setUserId(note.getUserId());
            if (note.getAnnonce() != null) {
                noteToUpdate.setAnnonce(note.getAnnonce());
            }
            return noteRepository.save(noteToUpdate);
        }
        return null;
    }

    @Override
    public List<Note> getNotesByUserID(Long userId) {
        return noteRepository.getNoteByUserId(userId);
    }

    @Override
    public List<Note> getNotesByAnnonceId(Long annonceId) {
        return noteRepository.getNotesByAnnonceId(annonceId);
    }

    @Override
    public void deleteNote(Long id) {
        noteRepository.deleteById(id);
    }
}
