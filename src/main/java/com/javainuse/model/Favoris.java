package com.javainuse.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Favoris {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    private String name;

    @Column(name = "user_id")
    private Long userId;

    @OneToMany
    private Set<Annonce> annonceSet = new HashSet<Annonce>();

    public Favoris() {
        annonceSet = new HashSet<>();
        name = "My favoris";
    }
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Annonce> getAnnonceSet() {
        return annonceSet;
    }

    public void setAnnonceSet(Set<Annonce> annonceSet) {
        this.annonceSet = annonceSet;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}
