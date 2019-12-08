package com.javainuse.model;

import javax.persistence.*;
import java.util.Date;

@Entity
public class SoldAnnonce {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "annonce_id")
    private Long annonceId;

    @Column(name = "owner_id")
    private Long ownerId;

    @Column(name = "selling_date")
    private Date sellingDate;

    @Column(name="available_house")
    private int availableHouses;

    @Column(name="selling_price")
    private Double sellingPrice;

    @Column(name = "number_houses")
    private int numberHouses;

    @Column(name = "number_bedrooms")
    private int numberBedrooms;


    public SoldAnnonce() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getAnnonceId() {
        return annonceId;
    }

    public void setAnnonceId(Long annonceId) {
        this.annonceId = annonceId;
    }

    public Long getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(Long ownerId) {
        this.ownerId = ownerId;
    }

    public Date getSellingDate() {
        return sellingDate;
    }

    public void setSellingDate(Date sellingDate) {
        this.sellingDate = sellingDate;
    }

    public Integer getAvailableHouses() {
        return availableHouses;
    }

    public void setAvailableHouses(Integer availableHouses) {
        this.availableHouses = availableHouses;
    }

    public Double getSellingPrice() {
        return sellingPrice;
    }

    public void setSellingPrice(Double sellingPrice) {
        this.sellingPrice = sellingPrice;
    }

    public void setAvailableHouses(int availableHouses) {
        this.availableHouses = availableHouses;
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

    @Override
    public String toString() {
        return "SoldAnnonce{" +
                "id=" + id +
                ", annonceId=" + annonceId +
                ", ownerId=" + ownerId +
                ", sellingDate='" + sellingDate + '\'' +
                '}';
    }
}
