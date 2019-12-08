package com.javainuse.model.DTO;

import com.javainuse.model.Annonce;
import com.javainuse.model.SoldAnnonce;

public class SoldAnnonceDTO {
    private Annonce annonce;
    private SoldAnnonce soldAnnonce;

    public SoldAnnonceDTO() {
    }

    public Annonce getAnnonce() {
        return annonce;
    }

    public void setAnnonce(Annonce annonce) {
        this.annonce = annonce;
    }

    public SoldAnnonce getSoldAnnonce() {
        return soldAnnonce;
    }

    public void setSoldAnnonce(SoldAnnonce soldAnnonce) {
        this.soldAnnonce = soldAnnonce;
    }

    @Override
    public String toString() {
        return "SoldAnnonceDTO{" +
                "annonce=" + annonce +
                ", soldAnnonce=" + soldAnnonce +
                '}';
    }
}
