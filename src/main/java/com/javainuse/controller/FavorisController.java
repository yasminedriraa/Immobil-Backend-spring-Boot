package com.javainuse.controller;

import com.javainuse.model.Annonce;
import com.javainuse.model.Favoris;
import com.javainuse.service.FavorisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
public class FavorisController {

    @Autowired
    private FavorisService favorisService;

    /**
     * create a favoris and returns it
     * @param favoris
     * @return
     */
    @PostMapping("/favoris")
    public ResponseEntity<?> createFavoris(@RequestBody Favoris favoris) {
        return ResponseEntity.ok(favorisService.createFavoris(favoris));
    }

    /**
     * get list of favoris
     * @return
     */
    @GetMapping("/favoris")
    public ResponseEntity<?> getAllFavoris() {
        return ResponseEntity.ok(favorisService.getAllFavoris());
    }

    /**
     * add annonce to  a favorites list
     * @param userId
     * @param annonceId
     * @return
     */
    @PutMapping("/favoris")
    public ResponseEntity<?> addAnnonceToFavoris(@RequestParam("id_user") Long userId, @RequestParam("id") Long annonceId) {
        return ResponseEntity.ok(favorisService.addAnnonceToFavoris(userId, annonceId));
    }

    /**
     * delete annonce from favoris
     * @param userId
     * @param annonceId
     * @return
     */
    @PutMapping("/deleteFromFavoris")
    public ResponseEntity<?> deleteAnnonceFromFavoris(@RequestParam("id_user") Long userId, @RequestParam("id") Long annonceId) {
        return ResponseEntity.ok(favorisService.deleteAnnonceFromFavoris(userId, annonceId));
    }

    /**
     * delete favoris by id
     * @param id
     */
    @DeleteMapping("/favoris/{id}")
    public void deleteFavoris(@PathVariable("id") Long id) {
        favorisService.deleteFavoris(id);
    }

    @GetMapping("/favorisById")
    public ResponseEntity<?> getAllFavorisByUserId(@RequestParam Long id) {
        return ResponseEntity.ok().body(favorisService.getAllFavorisByUserId(id));
    }
}
