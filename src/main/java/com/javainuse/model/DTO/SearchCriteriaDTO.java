package com.javainuse.model.DTO;

import com.javainuse.model.Annonce;
import com.javainuse.model.Category;
import com.javainuse.model.Location;

public class SearchCriteriaDTO {
    private Annonce.Atout atout;
    private Double prix_min;
    private Double prix_max;
    private Category category;
    private int rating;
    private Location location;
    private Double surface_min;
    private Double surface_max;
    public Annonce.Atout getAtout() {
        return atout;
    }

    public void setAtout(Annonce.Atout atout) {
        this.atout = atout;
    }

    public Double getPrix_min() {
        return prix_min;
    }

    public void setPrix_min(Double prix_min) {
        this.prix_min = prix_min;
    }

    public Double getPrix_max() {
        return prix_max;
    }

    public void setPrix_max(Double prix_max) {
        this.prix_max = prix_max;
    }

    public Double getSurface_min() {
        return surface_min;
    }

    public void setSurface_min(Double surface_min) {
        this.surface_min = surface_min;
    }

    public Double getSurface_max() {
        return surface_max;
    }

    public void setSurface_max(Double surface_max) {
        this.surface_max = surface_max;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
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

}
