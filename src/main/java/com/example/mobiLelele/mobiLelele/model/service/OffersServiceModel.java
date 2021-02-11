package com.example.mobiLelele.mobiLelele.model.service;

import com.example.mobiLelele.mobiLelele.model.entities.enums.Engines;
import com.example.mobiLelele.mobiLelele.model.entities.enums.Transmissions;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.math.BigDecimal;

public class OffersServiceModel {

    @NotNull
    @Length(min = 1)
    private String model;
    @NotNull
    private Engines engine;
    @NotNull
    @Length(min = 6)
    private String imageUrl;
    @NotNull
    @Positive()
    private int mileage;
    @NotNull
    @DecimalMin(value = "100")
    private BigDecimal price;
    @NotNull
    private int year;
    @Length(min = 6)
    private String description;
    @NotNull
    private Transmissions transmission;

    public OffersServiceModel() {
    }

    public Engines getEngine() {
        return engine;
    }

    public OffersServiceModel setEngine(Engines engine) {
        this.engine = engine;
        return this;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public OffersServiceModel setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
        return this;
    }

    public int getMileage() {
        return mileage;
    }

    public OffersServiceModel setMileage(int mileage) {
        this.mileage = mileage;
        return this;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public OffersServiceModel setPrice(BigDecimal price) {
        this.price = price;
        return this;
    }

    public int getYear() {
        return year;
    }

    public OffersServiceModel setYear(int year) {
        this.year = year;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public OffersServiceModel setDescription(String description) {
        this.description = description;
        return this;
    }

    public Transmissions getTransmission() {
        return transmission;
    }

    public OffersServiceModel setTransmission(Transmissions transmission) {
        this.transmission = transmission;
        return this;
    }

    public String getModel() {
        return model;
    }

    public OffersServiceModel setModel(String model) {
        this.model = model;
        return this;
    }
}
