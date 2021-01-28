package com.example.mobiLelele.mobiLelele.web;

import com.example.mobiLelele.mobiLelele.service.OfferService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/offers")
public class OffersController {
    private final OfferService offerService;

    public OffersController(OfferService offerService) {
        this.offerService = offerService;
    }

    @GetMapping("/all")
    private String allOffers(Model model){
        model.addAttribute("offers",offerService.getAllOffers());
        return "offers";
    }
}
