package com.example.mobiLelele.mobiLelele.service.impl;

import com.example.mobiLelele.mobiLelele.model.entities.ModelEntity;
import com.example.mobiLelele.mobiLelele.model.entities.Offer;
import com.example.mobiLelele.mobiLelele.model.view.OfferSummaryViewModel;
import com.example.mobiLelele.mobiLelele.model.view.OfferViewModel;
import com.example.mobiLelele.mobiLelele.repositoriy.ModelRepository;
import com.example.mobiLelele.mobiLelele.repositoriy.OfferRepository;
import com.example.mobiLelele.mobiLelele.repositoriy.UserRepository;
import com.example.mobiLelele.mobiLelele.security.CurrentUser;
import com.example.mobiLelele.mobiLelele.service.OfferService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class OfferServiceImpl implements OfferService {

    private OfferRepository offerRepository;
    private ModelMapper modelMapper;
    private final ModelRepository modelRepository;
    private final UserRepository userRepository;
    private final CurrentUser currentUser;


    public OfferServiceImpl(OfferRepository offerRepository, ModelMapper modelMapper, ModelRepository modelRepository, UserRepository userRepository, CurrentUser currentUser) {
        this.offerRepository = offerRepository;
        this.modelMapper = modelMapper;
        this.modelRepository = modelRepository;
        this.userRepository = userRepository;
        this.currentUser = currentUser;
    }

    @Override
    public List<OfferSummaryViewModel> getAllOffers() {
        List<OfferSummaryViewModel> result = new ArrayList<>();
        List<Offer> allOffers = this.offerRepository.findAll();

        allOffers.forEach(o -> {
            OfferSummaryViewModel offerSummaryViewModel = new OfferSummaryViewModel();
            this.modelMapper.map(o, offerSummaryViewModel);
            //offerSummaryViewModel.setUser(o.getSeller());
            result.add(offerSummaryViewModel);
        });

        return result;
    }

    @Override
    public long addOffer(OfferViewModel map) {
        Offer offer = this.modelMapper.map(map, Offer.class);
        ModelEntity modelEntity = map.getModelEntity();
        offer.setModel(modelEntity);
        offer.setSeller(this.userRepository.findByUsername(this.currentUser.getName()).orElse(null));
        this.offerRepository.save(offer);

        return offer.getId();
    }

    @Override
    public OfferSummaryViewModel findById(Long id) {
        Optional<Offer> offer = this.offerRepository.findById(id);
        OfferSummaryViewModel map = this.modelMapper.map(offer.orElse(null), OfferSummaryViewModel.class);
        map.setBrand(offer.get().getModel().getBrand());
        return map;
    }

    @Override
    public long updateOffer(OfferViewModel offerViewModel) {
        //TODO update Offer

        return 0;
    }


}
