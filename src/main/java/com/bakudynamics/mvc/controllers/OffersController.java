package com.bakudynamics.mvc.controllers;


import com.bakudynamics.mvc.dao.Offer;
import com.bakudynamics.mvc.service.OfferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;
import java.security.Principal;

@Controller
public class OffersController {

    private OfferService offerService;

    @RequestMapping("/offers")
    public String showOffers(Model model) {
        model.addAttribute("title", "Rahim Rahimli");
        model.addAttribute("offers", offerService.getOffers());
        return "offers/offers";
    }

    @RequestMapping("/offers/create")
    public String createOffer(Model model) {
        model.addAttribute("offer", new Offer());
        return "offers/offers.create";
    }

    @RequestMapping(value = "/offers/store", method = RequestMethod.POST)
    public String storeOffer(Model model, @Valid Offer offer, BindingResult result, Principal principal) {
        System.out.println(offer);

        if (result.hasErrors()) {

            return "offers/offers.create";
        }
        String username = principal.getName();
        offer.getUser().setUsername(username);
        offerService.create(offer);

        return "offers/offers.created";
    }

    @Autowired
    public void setOfferService(OfferService offerService) {
        this.offerService = offerService;
    }


}