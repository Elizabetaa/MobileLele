package com.example.mobiLelele.mobiLelele.service;

import com.example.mobiLelele.mobiLelele.model.entities.Offer;
import com.example.mobiLelele.mobiLelele.model.view.OfferSummaryViewModel;
import com.example.mobiLelele.mobiLelele.model.view.OfferViewModel;

import java.util.List;

public interface OfferService {

    List<OfferSummaryViewModel> getAllOffers();

    long addOffer(OfferViewModel map);

    OfferSummaryViewModel findById(Long valueOf);
}
