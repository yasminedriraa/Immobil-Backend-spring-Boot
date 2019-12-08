package com.javainuse.model.DTO;

import java.util.Objects;

public class StatDTO {
    private int numberBedrooms;
    private int totalNumber;
    private int availableNumber;
    private Double price;

    public StatDTO() {
    }

    public int getNumberBedrooms() {
        return numberBedrooms;
    }

    public void setNumberBedrooms(int numberBedrooms) {
        this.numberBedrooms = numberBedrooms;
    }

    public int getTotalNumber() {
        return totalNumber;
    }

    public void setTotalNumber(int totalNumber) {
        this.totalNumber = totalNumber;
    }

    public int getAvailableNumber() {
        return availableNumber;
    }

    public void setAvailableNumber(int availableNumber) {
        this.availableNumber = availableNumber;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StatDTO statDTO = (StatDTO) o;
        return numberBedrooms == statDTO.numberBedrooms &&
                totalNumber == statDTO.totalNumber &&
                availableNumber == statDTO.availableNumber &&
                Objects.equals(price, statDTO.price);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numberBedrooms, totalNumber, availableNumber, price);
    }
}
