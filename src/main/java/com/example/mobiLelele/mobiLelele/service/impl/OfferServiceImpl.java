package com.example.mobiLelele.mobiLelele.service.impl;

import com.example.mobiLelele.mobiLelele.model.entities.ModelEntity;
import com.example.mobiLelele.mobiLelele.model.entities.Offer;
import com.example.mobiLelele.mobiLelele.model.view.OfferSummaryViewModel;
import com.example.mobiLelele.mobiLelele.model.view.OfferViewModel;
import com.example.mobiLelele.mobiLelele.repositoriy.ModelRepository;
import com.example.mobiLelele.mobiLelele.repositoriy.OfferRepository;
import com.example.mobiLelele.mobiLelele.service.OfferService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OfferServiceImpl implements OfferService {

    private OfferRepository offerRepository;
    private ModelMapper modelMapper;
    private final ModelRepository modelRepository;


    public OfferServiceImpl(OfferRepository offerRepository, ModelMapper modelMapper, ModelRepository modelRepository) {
        this.offerRepository = offerRepository;
        this.modelMapper = modelMapper;
        this.modelRepository = modelRepository;
    }

    @Override
    public List<OfferSummaryViewModel> getAllOffers() {
        List<OfferSummaryViewModel> result = new ArrayList<>();
        List<Offer> allOffers = this.offerRepository.findAll();

        allOffers.forEach(o -> {
            OfferSummaryViewModel offerSummaryViewModel = new OfferSummaryViewModel();
            this.modelMapper.map(o,offerSummaryViewModel);
            result.add(offerSummaryViewModel);
        });

        return result;
    }

    @Override
    public long addOffer(OfferViewModel map) {
        Offer offer = this.modelMapper.map(map,Offer.class);
        ModelEntity modelEntity = map.getModelEntity();
        offer.setModel(modelEntity);
        this.offerRepository.save(offer);

        return offer.getId();
    }


}
