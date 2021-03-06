package com.example.mobiLelele.mobiLelele.model.entities;

import com.example.mobiLelele.mobiLelele.model.entities.enums.Engines;
import com.example.mobiLelele.mobiLelele.model.entities.enums.Transmissions;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "offers")
public class Offer extends BaseEntity{

    @Enumerated(EnumType.STRING)
    private Engines engine;
    private String imageUrl;
    private int mileage;
    private BigDecimal price;
    private int year;
    private String description;
    @Enumerated(EnumType.STRING)
    private Transmissions transmission;

    @ManyToOne()
    @JoinColumn(name = "model_id")
    private ModelEntity modelEntity;


    @ManyToOne()
    @JoinColumn(name = "seller_id")
    private User seller;



    public Engines getEngine() {
        return engine;
    }

    public Offer setEngine(Engines engine) {
        this.engine = engine;
        return this;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public Offer setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
        return this;
    }

    public int getMileage() {
        return mileage;
    }

    public Offer setMileage(int mileage) {
        this.mileage = mileage;
        return this;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public Offer setPrice(BigDecimal price) {
        this.price = price;
        return this;
    }

    public int getYear() {
        return year;
    }

    public Offer setYear(int year) {
        this.year = year;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public Offer setDescription(String description) {
        this.description = description;
        return this;
    }

    public Transmissions getTransmission() {
        return transmission;
    }

    public Offer setTransmission(Transmissions transmission) {
        this.transmission = transmission;
        return this;
    }

    public ModelEntity getModel() {
        return modelEntity;
    }

    public Offer setModel(ModelEntity modelEntity) {
        this.modelEntity = modelEntity;
        return this;
    }


    public User getSeller() {
        return seller;
    }

    public Offer setSeller(User seller) {
        this.seller = seller;
        return this;
    }
}
