package com.javainuse.service.impl;

import com.javainuse.model.*;
import com.javainuse.model.DTO.AnnonceDTO;
import com.javainuse.model.DTO.SearchCriteriaDTO;
import com.javainuse.model.DTO.SoldAnnonceDTO;
import com.javainuse.repository.AnnonceRepository;
import com.javainuse.repository.SoldAnnonceRepository;
import com.javainuse.repository.UserDao;
import com.javainuse.service.AnnonceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class AnnonceServiceImpl implements AnnonceService {

    @Autowired
    private AnnonceRepository annonceRepository;

    @Autowired
    private SoldAnnonceRepository soldAnnonceRepository;

    @Autowired
    UserDao userDao;

    @Override
    public Annonce createAnnonce(Annonce annonce) {
        if (annonce.getAvailableHouses() == 0) {
            annonce.setAvailableHouses(annonce.getNumberHouses());
        }
        return annonceRepository.save(annonce);
    }

    @Override
    public List<Annonce> getAllAnnonce() {
        return annonceRepository.findAll();
    }

    @Override
    public Annonce findAnnonceById(Long id) {
        return annonceRepository.findById(id).get();
    }

    @Override
    public Annonce updateAnnonce(Annonce annonce) {
        Annonce annonceFromDB = findAnnonceById(annonce.getId());
        if (annonceFromDB != null) {
            annonceFromDB.setId(annonce.getId());
            annonceFromDB.setAtouts(annonce.getAtouts());
            annonceFromDB.setDescription(annonce.getDescription());
            annonceFromDB.setLocation(annonce.getLocation());
            annonceFromDB.setPrix(annonce.getPrix());
            annonceFromDB.setRating(annonce.getRating());
            annonceFromDB.setUrlVideo(annonce.getUrlVideo());
            annonceFromDB.setDateDeLivraison(annonce.getDateDeLivraison());
            annonceFromDB.setTitle(annonce.getTitle());
            annonceFromDB.setNumberBedrooms(annonce.getNumberBedrooms());
            annonceFromDB.setNumberHouses(annonce.getNumberHouses());
            annonceFromDB.setAvailableHouses(annonce.getAvailableHouses());
            annonceFromDB.setUrlPicture(annonce.getUrlPicture());
            annonceFromDB.setSurface(annonce.getSurface());
           return annonceRepository.save(annonceFromDB);
        }
        return null;
    }

    @Override
    public void deleteAnnonce(Long id) {
        annonceRepository.deleteById(id);
    }

    @Override
    public List<Annonce> getAnnonceByCategory(Long categoryId) {
        return annonceRepository.getAnnonceByCategoryId(categoryId);
    }

    @Override
    public List<Annonce> searchForAnnonceByCriteria(SearchCriteriaDTO searchCriteriaDTO) {
        return annonceRepository.searchAnnonceByCriteria(searchCriteriaDTO.getAtout() != null ? searchCriteriaDTO.getAtout() : null, searchCriteriaDTO.getLocation() != null ? searchCriteriaDTO.getLocation().getVille() : "", searchCriteriaDTO.getCategory() != null ? searchCriteriaDTO.getCategory().getName() : "");
    }

    @Override
    public SoldAnnonceDTO sellAnnonceService(Long annonceId) {
        Annonce annonce = annonceRepository.findById(annonceId).get();
        SoldAnnonce soldAnnonce = new SoldAnnonce();
        SoldAnnonceDTO soldAnnonceDTO = new SoldAnnonceDTO();
        if (annonce != null) {
            if (annonce.getAvailableHouses() != 0) {
                int availableHouses = annonce.getAvailableHouses();
                annonce.setAvailableHouses(availableHouses - 1);
                annonceRepository.save(annonce);
                 soldAnnonce.setAnnonceId(annonce.getId());
                 soldAnnonce.setOwnerId(annonce.getUserId());
                 soldAnnonce.setSellingDate(new Date());
                 soldAnnonce.setAvailableHouses(annonce.getAvailableHouses());
                 soldAnnonce.setNumberBedrooms(annonce.getNumberBedrooms());
                 soldAnnonce.setNumberHouses(annonce.getNumberHouses());
                 soldAnnonce.setSellingPrice(annonce.getPrix());
                 soldAnnonceRepository.save(soldAnnonce);
                soldAnnonceDTO.setAnnonce(annonce);
                soldAnnonceDTO.setSoldAnnonce(soldAnnonce);
                return soldAnnonceDTO;
            }
        }
        return soldAnnonceDTO;
    }

    @Override
    public List<Annonce> getAllAnnonceByUserId(Long userId) {
        return annonceRepository.getAllByUserId(userId);
    }

}
