package com.example.mobiLelele.mobiLelele.web;

import com.example.mobiLelele.mobiLelele.model.entities.enums.Engines;
import com.example.mobiLelele.mobiLelele.model.entities.enums.Transmissions;
import com.example.mobiLelele.mobiLelele.model.service.OffersServiceModel;
import com.example.mobiLelele.mobiLelele.model.view.OfferUpdate;
import com.example.mobiLelele.mobiLelele.repositoriy.ModelRepository;
import com.example.mobiLelele.mobiLelele.service.BrandService;
import com.example.mobiLelele.mobiLelele.service.OfferService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
@RequestMapping("/offers")
public class OffersController {
    private final OfferService offerService;
    private final BrandService brandService;
    private final ModelRepository modelRepository;
    private final ModelMapper modelMapper;

    public OffersController(OfferService offerService, BrandService brandService, ModelRepository modelRepository, ModelMapper modelMapper) {
        this.offerService = offerService;
        this.brandService = brandService;
        this.modelRepository = modelRepository;
        this.modelMapper = modelMapper;
    }

    @GetMapping("/all")
    private String allOffers(Model model) {
        model.addAttribute("offers", offerService.getAllOffers());
        return "offers";
    }

    @GetMapping("/add")
    private String addOffer(Model model) {

        model.addAttribute("brands", this.brandService.getAllBrands());
        model.addAttribute("engines", Engines.values());
        model.addAttribute("transmissions", Transmissions.values());

        if (!model.containsAttribute("offersServiceModel")){
            model.addAttribute("offersServiceModel",new OffersServiceModel());
        }
        return "offer-add";
    }

    @PostMapping("/add")
    private String uploadOffer(@Valid OffersServiceModel offersServiceModel, BindingResult bindingResult, RedirectAttributes redirectAttributes){

        if (bindingResult.hasErrors()){
            redirectAttributes.addFlashAttribute("offersServiceModel",offersServiceModel);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.offersServiceModel",bindingResult);

            return "redirect:add";
        }

        this.offerService.addOffer(this.modelMapper.map(offersServiceModel, OfferUpdate.class), offersServiceModel.getModel());

        return "redirect:/offers/all";
    }

    @GetMapping("/details")
    public String details(){
        return "details";
    }
}























