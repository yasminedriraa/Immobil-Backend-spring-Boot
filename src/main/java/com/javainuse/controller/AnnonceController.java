package com.javainuse.controller;

import com.fasterxml.jackson.annotation.JsonView;
import com.javainuse.model.Annonce;
import com.javainuse.model.DTO.SearchCriteriaDTO;
import com.javainuse.service.AnnonceService;
import com.javainuse.service.SoldeAnnonceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.xml.ws.Response;
import java.util.List;

@RestController
@CrossOrigin
@JsonView
@RequestMapping("/api/v1")
public class AnnonceController {

    @Autowired
    private AnnonceService annonceService;

    @Autowired
    private SoldeAnnonceService soldeAnnonceService;

    /**
     * return an array of annonce
     *
     * @return
     */
    @GetMapping("/getAllAnnonce")
    public ResponseEntity<List<Annonce>> getAllAnnonce() {
        return new ResponseEntity<>(annonceService.getAllAnnonce(), HttpStatus.OK);
    }

    /**
     * create annonce
     *
     * @param annonce
     * @return
     */
    @PostMapping("/create-annonce")
    public ResponseEntity<Annonce> createAnnonce(@RequestBody  Annonce annonce) {
        return new ResponseEntity<>(annonceService.createAnnonce(annonce), HttpStatus.OK);
    }

    /**
     * returns annonce by id
     *
     * @param id
     * @return
     */
    @GetMapping("/get-annonce-byID/{id}")
    public ResponseEntity<Annonce> getAnnonceById(@PathVariable("id") Long id) {
        return new ResponseEntity<>(annonceService.findAnnonceById(id), HttpStatus.OK);
    }

    /**
     * update annonce with a givin id
     *
     *
     * @param annonce
     * @return
     */
    @PutMapping("/update-annonce")
    public ResponseEntity<Annonce> updateAnnonce(@RequestBody Annonce annonce) {
        return new ResponseEntity<>(annonceService.updateAnnonce(annonce), HttpStatus.OK);
    }

    /**
     * delete annonce with id
     *
     * @param id
     */
    @DeleteMapping("/delete-annonce/{id}")
    public void deleteAnnonce(@PathVariable("id") Long id) {
        annonceService.deleteAnnonce(id);
    }

    /**
     * get annonce with category id
     *
     * @param id
     * @return
     */
    @GetMapping("/annonces/category/{id}")
    public ResponseEntity<?> getAnnonceByCategoryId(@PathVariable("id") Long id) {
        return ResponseEntity.ok(annonceService.getAnnonceByCategory(id));
    }

    @PostMapping("/annonces/search")
    public ResponseEntity<?> searchForAnnonceByCriteria(@RequestBody SearchCriteriaDTO searchCriteriaDTO) {
        return ResponseEntity.ok().body(annonceService.searchForAnnonceByCriteria(searchCriteriaDTO));
    }

    @GetMapping("/annonce/sell")
    public ResponseEntity<?>sellAnnonceService(@RequestParam("annonceId") Long annonceId) {
        return ResponseEntity.ok().body(annonceService.sellAnnonceService(annonceId));
    }

    @GetMapping("/annonce/statistics")
    public ResponseEntity<?>getStatistics(@RequestParam("ownerId") Long ownerId){
        return ResponseEntity.ok().body(soldeAnnonceService.getAllByOwnerIdForStatistics(ownerId));
    }

    @GetMapping("/annonce/statistics/monthly")
    public ResponseEntity<?>getStatisticsMonthlyByUserId(@RequestParam("ownerId") Long ownerId) {
        return ResponseEntity.ok().body(soldeAnnonceService.getStatisticsMonthlyByUserId(ownerId));
    }

    @GetMapping("/annonce/userId")
    public ResponseEntity<?>getAllAnnonceByUserId(@RequestParam("userId") Long userId) {
        return ResponseEntity.ok().body(annonceService.getAllAnnonceByUserId(userId));
    }
}
