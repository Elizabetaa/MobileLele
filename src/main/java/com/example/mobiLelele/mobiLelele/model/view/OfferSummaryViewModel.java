package com.example.mobiLelele.mobiLelele.model.view;

import com.example.mobiLelele.mobiLelele.model.entities.Brand;
import com.example.mobiLelele.mobiLelele.model.entities.ModelEntity;
import com.example.mobiLelele.mobiLelele.model.entities.User;
import com.example.mobiLelele.mobiLelele.model.entities.enums.Engines;
import com.example.mobiLelele.mobiLelele.model.entities.enums.Transmissions;

import java.math.BigDecimal;

public class OfferSummaryViewModel {

    private Long id;
    private String imageUrl;
    private int mileage;
    private BigDecimal price;
    private Transmissions transmission;
    private Engines engine;
    private int year;
    private ModelEntity modelEntity;
    private Brand brand;


    public Brand getBrand() {
        return brand;
    }

    public OfferSummaryViewModel setBrand(Brand brand) {
        this.brand = brand;
        return this;
    }

    private  User seller;

    public String getImageUrl() {
        return imageUrl;
    }

    public User getSeller() {
        return seller;
    }

    public OfferSummaryViewModel setSeller(User seller) {
        this.seller = seller;
        return this;
    }

    public OfferSummaryViewModel setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
        return this;
    }

    public ModelEntity getModelEntity() {
        return modelEntity;
    }

    public OfferSummaryViewModel setModelEntity(ModelEntity modelEntity) {
        this.modelEntity = modelEntity;
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

    public ModelEntity getModel() {
        return modelEntity;
    }

    public OfferSummaryViewModel setModel(ModelEntity modelEntity) {
        this.modelEntity = modelEntity;
        return this;
    }

    public Long getId() {
        return id;
    }

    public OfferSummaryViewModel setId(Long id) {
        this.id = id;
        return this;
    }
}
