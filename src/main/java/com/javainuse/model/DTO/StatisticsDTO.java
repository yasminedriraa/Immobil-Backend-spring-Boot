package com.javainuse.model.DTO;

import java.util.HashMap;
import java.util.List;
import java.util.Objects;
import java.util.Set;

public class StatisticsDTO {
    private List<StatDTO> statDTOS;
    private Set<ObjectPercentage> objectPercentage;
    private int hashCode;
    public StatisticsDTO() {
    }

    public List<StatDTO> getStatDTOS() {
        return statDTOS;
    }

    public void setStatDTOS(List<StatDTO> statDTOS) {
        this.statDTOS = statDTOS;
    }

    public Set<ObjectPercentage> getObjectPercentage() {
        return objectPercentage;
    }

    public void setObjectPercentage(Set<ObjectPercentage> objectPercentage) {
        this.objectPercentage = objectPercentage;
    }

    @Override
    public boolean equals(Object obj) {

        StatisticsDTO statisticsDTO = (StatisticsDTO)obj;

        if(statDTOS.equals(statisticsDTO.statDTOS) &&
                objectPercentage.equals(statisticsDTO.objectPercentage))
        {
            hashCode = statisticsDTO.hashCode;
            return true;
        }else{
            hashCode = super.hashCode();
            return false;
        }
    }
    @Override
    public String toString() {
        return "StatisticsDTO{" +
                "statDTOS=" + statDTOS +
                ", objectPercentage=" + objectPercentage +
                '}';
    }
}
