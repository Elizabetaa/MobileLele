package com.example.mobiLelele.mobiLelele.model.service;

import com.example.mobiLelele.mobiLelele.model.entities.enums.Engines;
import com.example.mobiLelele.mobiLelele.model.entities.enums.Transmissions;
import com.example.mobiLelele.mobiLelele.model.validations.YearOnPastOrPresent;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Positive;
import java.math.BigDecimal;

public class OffersServiceModel {

    @NotNull
    private Engines engine;
    @NotNull
    @Pattern(regexp = "http[s]?:\\/\\/.+")
    private String imageUrl;
    @NotNull
    @Positive()
    private int mileage;
    @NotNull
    @DecimalMin(value = "100")
    private BigDecimal price;
    @NotNull
    @YearOnPastOrPresent(minYear = 1930)
    private int year;
    @Length(min = 6)
    private String description;
    @NotNull
    private Transmissions transmission;
    @NotNull
    private Integer modelId;

    public Integer getModelId() {
        return modelId;
    }

    public OffersServiceModel setModelId(Integer modelId) {
        this.modelId = modelId;
        return this;
    }

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


}
