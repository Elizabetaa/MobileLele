package com.example.mobiLelele.mobiLelele.service;

import com.example.mobiLelele.mobiLelele.model.view.OfferSummaryViewModel;
import org.apache.catalina.LifecycleState;

import java.util.List;

public interface OfferService {

    List<OfferSummaryViewModel> getAllOffers();
}
