package com.javainuse.service.impl;

import com.javainuse.model.Annonce;
import com.javainuse.model.Favoris;
import com.javainuse.repository.AnnonceRepository;
import com.javainuse.repository.FavorisRepository;
import com.javainuse.service.FavorisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FavorisServiceImpl implements FavorisService {
    @Autowired
    private FavorisRepository favorisRepository;

    @Autowired
    private AnnonceRepository annonceRepository;
    @Override
    public List<Favoris> getAllFavoris() {
        return favorisRepository.findAll();
    }

    @Override
    public Favoris createFavoris(Favoris favoris) {
        return favorisRepository.save(favoris);
    }

    @Override
    public Favoris addAnnonceToFavoris(Long userId, Long annonceId) {
        Favoris favoris = favorisRepository.getFavorisByUserId(userId);
        Annonce annonceToAdd = annonceRepository.findById(annonceId).get();
        if (favoris != null) {
          if (annonceToAdd != null) {
              favoris.getAnnonceSet().add(annonceToAdd);
              return favorisRepository.save(favoris);
          }
        }else {
            favoris = new Favoris();
            favoris.setUserId(userId);
            favoris.getAnnonceSet().add(annonceToAdd);
            return favorisRepository.save(favoris);
        }
        return null;
    }

    @Override
    public Favoris deleteAnnonceFromFavoris(Long userId, Long annonceId) {
        Favoris favoris = favorisRepository.getFavorisByUserId(userId);
        Annonce annonce = annonceRepository.findById(annonceId).get();
        if (annonce != null) {
            if (favoris != null) {
                if (!favoris.getAnnonceSet().isEmpty()) {
                    for (Annonce a : favoris.getAnnonceSet()) {
                        if (a.getId() == annonce.getId()) {
                            favoris.getAnnonceSet().remove(a);
                        }
                    }
                    return favorisRepository.save(favoris);
                }
            }
        }
        return null;
    }

    @Override
    public void deleteFavoris(Long id) {
        favorisRepository.deleteById(id);
    }

    @Override
    public Favoris getAllFavorisByUserId(Long id) {
        return favorisRepository.getFavorisByUserId(id);
    }
}
