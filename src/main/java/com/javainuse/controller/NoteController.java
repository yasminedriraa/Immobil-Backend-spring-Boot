package com.javainuse.controller;

import com.javainuse.model.Note;
import com.javainuse.service.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/api/v1")
public class NoteController {

    @Autowired
    private NoteService noteService;

    /**
     * creates a note and returns it
     * @param note
     * @return
     */
    @PostMapping("/notes")
    public ResponseEntity<?> createNote(@RequestBody Note note) {
        return ResponseEntity.ok(noteService.createNote(note));
    }

    /**
     * get all notes
     * @return
     */
    @GetMapping("/notes")
    public ResponseEntity<?> getAllNotes() {
        return ResponseEntity.ok(noteService.getAllNotes());
    }

    /**
     * get note by id
     * @param id
     * @return
     */
    @GetMapping("/notes/{id}")
    public ResponseEntity<?> getOneNote(@PathVariable("id") Long id) {
        return ResponseEntity.ok(noteService.getNoteById(id));
    }

    /**
     * update note by id
     * @param id
     * @param note
     * @return
     */
    @PutMapping("/notes")
    public ResponseEntity<?> updateNote(@RequestBody Note note) throws Exception {
        return ResponseEntity.ok(noteService.updateNote(note));
    }

    /**
     * delete a note by giving id
     * @param id
     */
    @DeleteMapping("/notes")
    public ResponseEntity<?> deleteNote(@RequestParam("id_note") Long id) {
        noteService.deleteNote(id);
        return ResponseEntity.ok().body("Deleted note "+ id);
    }

    /**
     * get list of notes by user id
     * @param userId
     * @return
     */
    @GetMapping("/notesByUserId")
    public ResponseEntity<?> getNotesByUserID(@RequestParam("user_id") Long userId) {
        return ResponseEntity.ok(noteService.getNotesByUserID(userId));
    }

    /**
     * get list of note by annonce id
     * @param annonceId
     * @return
     */
    @GetMapping("/notes/annonce/{annonceId}")
    public ResponseEntity<?> getNotesByAnnonceId(@PathVariable("annonceId") Long annonceId) {
        return ResponseEntity.ok(noteService.getNotesByAnnonceId(annonceId));
    }
}
