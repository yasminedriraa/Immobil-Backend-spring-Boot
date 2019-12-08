package com.javainuse.service;

import com.javainuse.model.Annonce;
import com.javainuse.model.Favoris;

import java.util.List;

public interface FavorisService {
    List<Favoris> getAllFavoris();
    Favoris createFavoris(Favoris favoris);
    Favoris addAnnonceToFavoris(Long userId, Long annonceId);
    Favoris deleteAnnonceFromFavoris(Long userId , Long annonceId);
    void deleteFavoris(Long id);
    Favoris getAllFavorisByUserId(Long id);
}
