package com.javainuse.repository;

import com.javainuse.model.SoldAnnonce;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SoldAnnonceRepository extends JpaRepository<SoldAnnonce, Long> {
    List<SoldAnnonce> getAllByOwnerId(Long ownerId);
}
