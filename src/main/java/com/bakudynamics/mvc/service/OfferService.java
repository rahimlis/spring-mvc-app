package com.bakudynamics.mvc.service;

import com.bakudynamics.mvc.dao.Offer;
import com.bakudynamics.mvc.dao.OfferDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.DataRetrievalFailureException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OfferService {

    private OfferDao offerDao;

    public List<Offer> getOffers() {
        return offerDao.offers();
    }

    public void create(Offer offer) {
        offerDao.create(offer);
    }

    @Autowired
    public void setOfferDao(OfferDao offerDao) {
        this.offerDao = offerDao;
    }

    public void throwNewDatabaseException() {
        throw new DataRetrievalFailureException("test exception");
    }
}
