package com.javainuse.model.DTO;

public class LinesStatistics {
    private int monthIndex;
    private int incomesMonthIndex;

    public LinesStatistics() {
    }

    public int getMonthIndex() {
        return monthIndex;
    }

    public void setMonthIndex(int monthIndex) {
        this.monthIndex = monthIndex;
    }

    public int getIncomesMonthIndex() {
        return incomesMonthIndex;
    }

    public void setIncomesMonthIndex(int incomesMonthIndex) {
        this.incomesMonthIndex = incomesMonthIndex;
    }

    @Override
    public String toString() {
        return "LinesStatistics{" +
                "monthIndex=" + monthIndex +
                ", incomesMonthIndex=" + incomesMonthIndex +
                '}';
    }
}
