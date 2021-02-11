package com.example.mobiLelele.mobiLelele.model.view;

import com.example.mobiLelele.mobiLelele.model.entities.ModelEntity;
import com.example.mobiLelele.mobiLelele.model.entities.enums.Engines;
import com.example.mobiLelele.mobiLelele.model.entities.enums.Transmissions;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.math.BigDecimal;

public class OfferUpdate {

    private Engines engine;
    private String imageUrl;
    private int mileage;
    private BigDecimal price;
    private int year;
    private String description;
    private Transmissions transmission;
    private ModelEntity modelEntity;

    public OfferUpdate() {
    }

    public Engines getEngine() {
        return engine;
    }

    public OfferUpdate setEngine(Engines engine) {
        this.engine = engine;
        return this;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public OfferUpdate setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
        return this;
    }

    public int getMileage() {
        return mileage;
    }

    public OfferUpdate setMileage(int mileage) {
        this.mileage = mileage;
        return this;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public OfferUpdate setPrice(BigDecimal price) {
        this.price = price;
        return this;
    }

    public int getYear() {
        return year;
    }

    public OfferUpdate setYear(int year) {
        this.year = year;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public OfferUpdate setDescription(String description) {
        this.description = description;
        return this;
    }

    public Transmissions getTransmission() {
        return transmission;
    }

    public OfferUpdate setTransmission(Transmissions transmission) {
        this.transmission = transmission;
        return this;
    }

    public ModelEntity getModelEntity() {
        return modelEntity;
    }

    public OfferUpdate setModelEntity(ModelEntity modelEntity) {
        this.modelEntity = modelEntity;
        return this;
    }
}
