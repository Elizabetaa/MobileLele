package com.example.mobiLelele.mobiLelele.model.view;

import com.example.mobiLelele.mobiLelele.model.entities.ModelEntity;
import com.example.mobiLelele.mobiLelele.model.entities.enums.Engines;
import com.example.mobiLelele.mobiLelele.model.entities.enums.Transmissions;

import java.math.BigDecimal;

public class OfferViewModel {

    private Engines engine;
    private String imageUrl;
    private int mileage;
    private BigDecimal price;
    private int year;
    private String description;
    private Transmissions transmission;
    private ModelEntity modelEntity;

    public OfferViewModel() {
    }

    public Engines getEngine() {
        return engine;
    }

    public OfferViewModel setEngine(Engines engine) {
        this.engine = engine;
        return this;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public OfferViewModel setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
        return this;
    }

    public int getMileage() {
        return mileage;
    }

    public OfferViewModel setMileage(int mileage) {
        this.mileage = mileage;
        return this;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public OfferViewModel setPrice(BigDecimal price) {
        this.price = price;
        return this;
    }

    public int getYear() {
        return year;
    }

    public OfferViewModel setYear(int year) {
        this.year = year;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public OfferViewModel setDescription(String description) {
        this.description = description;
        return this;
    }

    public Transmissions getTransmission() {
        return transmission;
    }

    public OfferViewModel setTransmission(Transmissions transmission) {
        this.transmission = transmission;
        return this;
    }

    public ModelEntity getModelEntity() {
        return modelEntity;
    }

    public OfferViewModel setModelEntity(ModelEntity modelEntity) {
        this.modelEntity = modelEntity;
        return this;
    }
}
