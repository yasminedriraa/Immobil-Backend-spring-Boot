package com.javainuse.repository;

import com.javainuse.model.Annonce;
import com.javainuse.model.DTO.SearchCriteriaDTO;
import com.javainuse.model.Location;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AnnonceRepository extends JpaRepository<Annonce, Long> {
    List<Annonce> getAnnonceByCategoryId(Long id);

    List<Annonce>getAllByUserId(Long userId);

    @Query("Select annonce from Annonce annonce where annonce.atouts like :atout and  annonce.location.ville like :ville  and annonce.category.name like :name")
    List<Annonce> searchAnnonceByCriteria(@Param("atout") Annonce.Atout atout, @Param("ville") String ville, @Param("name") String name);
}
