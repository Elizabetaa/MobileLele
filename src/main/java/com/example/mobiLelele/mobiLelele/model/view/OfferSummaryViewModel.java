package com.example.mobiLelele.mobiLelele.model.view;

import com.example.mobiLelele.mobiLelele.model.entities.Model;
import com.example.mobiLelele.mobiLelele.model.entities.enums.Engines;
import com.example.mobiLelele.mobiLelele.model.entities.enums.Transmissions;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.math.BigDecimal;

public class OfferSummaryViewModel {

    private String imageUrl;
    private int mileage;
    private BigDecimal price;
    private Transmissions transmission;
    private Engines engine;
    private int year;
    private Model model;

    public String getImageUrl() {
        return imageUrl;
    }

    public OfferSummaryViewModel setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
        return this;
    }

    public int getMileage() {
        return mileage;
    }

    public OfferSummaryViewModel setMileage(int mileage) {
        this.mileage = mileage;
        return this;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public OfferSummaryViewModel setPrice(BigDecimal price) {
        this.price = price;
        return this;
    }

    public Transmissions getTransmission() {
        return transmission;
    }

    public OfferSummaryViewModel setTransmission(Transmissions transmission) {
        this.transmission = transmission;
        return this;
    }

    public Engines getEngine() {
        return engine;
    }

    public OfferSummaryViewModel setEngine(Engines engine) {
        this.engine = engine;
        return this;
    }

    public int getYear() {
        return year;
    }

    public OfferSummaryViewModel setYear(int year) {
        this.year = year;
        return this;
    }

    public Model getModel() {
        return model;
    }

    public OfferSummaryViewModel setModel(Model model) {
        this.model = model;
        return this;
    }
}
