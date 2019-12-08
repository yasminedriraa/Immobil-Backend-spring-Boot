package com.javainuse.model.DTO;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.javainuse.model.Annonce;
import com.javainuse.model.Category;
import com.javainuse.model.Location;
import com.javainuse.model.Note;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

public class AnnonceDTO {
    private Long id;
    private Location location;
    private Category category;
    private Set<Note> notes = new HashSet<Note>();
    private Annonce.Atout atouts;
    private Double prix;
    private String description;
    private String dateDeLivraison;
    private String urlVideo;
    private int rating;
    private Long userId;
    private String title;
    private String urlPicture;
    private Double surface;
    private int numberHouses;
    private int numberBedrooms;
    private int availableHouses;
    private String entreprise;
    public AnnonceDTO() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Set<Note> getNotes() {
        return notes;
    }

    public void setNotes(Set<Note> notes) {
        this.notes = notes;
    }

    public Annonce.Atout getAtouts() {
        return atouts;
    }

    public void setAtouts(Annonce.Atout atouts) {
        this.atouts = atouts;
    }

    public Double getPrix() {
        return prix;
    }

    public void setPrix(Double prix) {
        this.prix = prix;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDateDeLivraison() {
        return dateDeLivraison;
    }

    public void setDateDeLivraison(String dateDeLivraison) {
        this.dateDeLivraison = dateDeLivraison;
    }

    public String getUrlVideo() {
        return urlVideo;
    }

    public void setUrlVideo(String urlVideo) {
        this.urlVideo = urlVideo;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUrlPicture() {
        return urlPicture;
    }

    public void setUrlPicture(String urlPicture) {
        this.urlPicture = urlPicture;
    }

    public Double getSurface() {
        return surface;
    }

    public void setSurface(Double surface) {
        this.surface = surface;
    }

    public int getNumberHouses() {
        return numberHouses;
    }

    public void setNumberHouses(int numberHouses) {
        this.numberHouses = numberHouses;
    }

    public int getNumberBedrooms() {
        return numberBedrooms;
    }

    public void setNumberBedrooms(int numberBedrooms) {
        this.numberBedrooms = numberBedrooms;
    }

    public int getAvailableHouses() {
        return availableHouses;
    }

    public void setAvailableHouses(int availableHouses) {
        this.availableHouses = availableHouses;
    }

    public String getEntreprise() {
        return entreprise;
    }

    public void setEntreprise(String entreprise) {
        this.entreprise = entreprise;
    }
}
