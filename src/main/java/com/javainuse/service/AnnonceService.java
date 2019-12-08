package com.javainuse.service;

import com.javainuse.model.Annonce;
import com.javainuse.model.Category;
import com.javainuse.model.DTO.SearchCriteriaDTO;
import com.javainuse.model.DTO.SoldAnnonceDTO;
import com.javainuse.model.Location;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AnnonceService {
    Annonce createAnnonce(Annonce annonce);
    List<Annonce> getAllAnnonce();
    Annonce findAnnonceById(Long id);
    Annonce updateAnnonce(Annonce annonce);
    void deleteAnnonce(Long id);
    List<Annonce> getAnnonceByCategory(Long categoryId);
    List<Annonce> searchForAnnonceByCriteria(SearchCriteriaDTO searchCriteriaDTO);
    SoldAnnonceDTO sellAnnonceService(Long annonceId);
    List<Annonce>getAllAnnonceByUserId(Long userId);
}
