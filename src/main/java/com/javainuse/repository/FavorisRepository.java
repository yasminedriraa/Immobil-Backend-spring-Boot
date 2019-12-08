package com.javainuse.repository;

import com.javainuse.model.Favoris;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FavorisRepository extends JpaRepository<Favoris, Long> {
    Favoris getFavorisByUserId(Long userId);
}
