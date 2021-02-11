package com.example.mobiLelele.mobiLelele.service;

import com.example.mobiLelele.mobiLelele.model.view.OfferSummaryViewModel;
import com.example.mobiLelele.mobiLelele.model.view.OfferUpdate;

import java.util.List;

public interface OfferService {

    List<OfferSummaryViewModel> getAllOffers();

    void updateOffer(OfferUpdate map, String model);
}
