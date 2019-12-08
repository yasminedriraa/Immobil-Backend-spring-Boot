package com.javainuse.model.DTO;

import java.util.List;

public class GraphDTO {
    private List<LinesStatistics> linesStatistics;

    public GraphDTO() {
    }

    public List<LinesStatistics> getLinesStatistics() {
        return linesStatistics;
    }

    public void setLinesStatistics(List<LinesStatistics> linesStatistics) {
        this.linesStatistics = linesStatistics;
    }

    @Override
    public String toString() {
        return "GraphDTO{" +
                "linesStatistics=" + linesStatistics +
                '}';
    }
}
