package com.javainuse.service.impl;

import com.javainuse.model.DTO.*;
import com.javainuse.model.SoldAnnonce;
import com.javainuse.repository.SoldAnnonceRepository;
import com.javainuse.service.SoldeAnnonceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class SoldAnnonceServiceImpl implements SoldeAnnonceService {

    @Autowired
    private SoldAnnonceRepository soldAnnonceRepository;

    @Override
    public SoldAnnonce createSoldeAnnonce(SoldAnnonce soldAnnonce) {
        return soldAnnonceRepository.save(soldAnnonce);
    }

    @Override
    public StatisticsDTO getAllByOwnerIdForStatistics(Long ownerId) {
        List<SoldAnnonce> soldAnnonces = soldAnnonceRepository.getAllByOwnerId(ownerId);
        StatisticsDTO statisticsDTO = new StatisticsDTO();
        List<StatDTO> statDTOS = new ArrayList<>();
        List<ObjectPercentage>objectPercentages = new ArrayList<>();
        int total = 0;
        for(SoldAnnonce soldAnnonce : soldAnnonces) {
            total += soldAnnonce.getNumberHouses();
        }
        if (soldAnnonces != null) {
            if (soldAnnonces.size() != 0) {
                for (SoldAnnonce soldAnnonce : soldAnnonces) {
                    StatDTO statDTO = new StatDTO();
                    ObjectPercentage objectPercentage = new ObjectPercentage();
                    if (soldAnnonce.getNumberBedrooms() == 0) {
                        statDTO.setNumberBedrooms(0);
                    } else if (soldAnnonce.getNumberBedrooms() == 1) {
                        statDTO.setNumberBedrooms(1);
                    } else if (soldAnnonce.getNumberBedrooms() == 2) {
                        statDTO.setNumberBedrooms(2);
                    } else if (soldAnnonce.getNumberBedrooms() == 3) {
                        statDTO.setNumberBedrooms(3);
                    }
                    statDTO.setAvailableNumber(soldAnnonce.getAvailableHouses());
                    statDTO.setTotalNumber(soldAnnonce.getNumberHouses());
                    statDTO.setPrice(soldAnnonce.getSellingPrice());
                    if (soldAnnonce.getNumberHouses() != 0) {
                       objectPercentage.setNumberBedrooms(soldAnnonce.getNumberBedrooms());
                       objectPercentage.setPercentage(((float)soldAnnonce.getNumberHouses() / (float)total) * 100);
                    } else {
                        objectPercentage.setNumberBedrooms(soldAnnonce.getNumberBedrooms());
                        objectPercentage.setPercentage(0f);
                    }
                    statDTOS.add(statDTO);
                    objectPercentages.add(objectPercentage);
                }
                
                Set<ObjectPercentage> setOfObjectPercentage = new LinkedHashSet<>(objectPercentages);
                statisticsDTO.setObjectPercentage(setOfObjectPercentage);
                statisticsDTO.setStatDTOS(statDTOS);
                return statisticsDTO;
            }
        }
        return null;
    }

    @Override
    public GraphDTO getStatisticsMonthlyByUserId(Long ownerId) {
        List<SoldAnnonce> soldAnnonces = soldAnnonceRepository.getAllByOwnerId(ownerId);
        GraphDTO graphDTO = new GraphDTO();
        List<LinesStatistics> linesStatisticsList = new ArrayList<>();
        if (soldAnnonces != null) {
            if (soldAnnonces.size() != 0) {
                for (SoldAnnonce soldAnnonce : soldAnnonces) {
                    LinesStatistics linesStatistics = new LinesStatistics();
                    LocalDate localDate = soldAnnonce.getSellingDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
                    int month = localDate.getMonthValue();
                    linesStatistics.setMonthIndex(month);
                    linesStatistics.setIncomesMonthIndex((int)(double)soldAnnonce.getSellingPrice());
                    linesStatisticsList.add(linesStatistics);
                    graphDTO.setLinesStatistics(linesStatisticsList);
                }
                return graphDTO;
            }
        }
        return null;
    }
}
