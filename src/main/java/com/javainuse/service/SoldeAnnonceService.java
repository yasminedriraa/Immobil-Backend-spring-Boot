package com.javainuse.service;

import com.javainuse.model.DTO.GraphDTO;
import com.javainuse.model.DTO.StatisticsDTO;
import com.javainuse.model.SoldAnnonce;

import java.util.List;

public interface SoldeAnnonceService {
    SoldAnnonce createSoldeAnnonce(SoldAnnonce soldAnnonce);
    StatisticsDTO getAllByOwnerIdForStatistics(Long ownerId);
    GraphDTO getStatisticsMonthlyByUserId(Long ownerId);
}
