package com.example.mobiLelele.mobiLelele.model.entities;

import com.example.mobiLelele.mobiLelele.model.entities.enums.Categories;

import javax.persistence.*;

@Entity
@Table(name = "models")
public class ModelEntity extends BaseEntity {

    private String name;

    @Enumerated(EnumType.STRING)
    private Categories category;

    @Column(length = 512)
    private String imageUrl;

    private int startYear;

    private Integer endYear;

    @ManyToOne()
    private Brand brand;

    public String getName() {
        return name;
    }

    public ModelEntity setName(String name) {
        this.name = name;
        return this;
    }

    public Categories getCategory() {
        return category;
    }

    public ModelEntity setCategory(Categories category) {
        this.category = category;
        return this;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public ModelEntity setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
        return this;
    }

    public int getStartYear() {
        return startYear;
    }

    public ModelEntity setStartYear(int startYear) {
        this.startYear = startYear;
        return this;
    }

    public Integer getEndYear() {
        return endYear;
    }

    public ModelEntity setEndYear(Integer endYear) {
        this.endYear = endYear;
        return this;
    }

    public Brand getBrand() {
        return brand;
    }

    public ModelEntity setBrand(Brand brand) {
        this.brand = brand;
        return this;
    }

    @Override
    public String toString() {
        return "ModelEntity{" +
                "name='" + name + '\'' +
                ", category=" + category +
                ", imageUrl='" + imageUrl + '\'' +
                ", startYear=" + startYear +
                ", endYar=" + endYear +
                ", brand=" + brand +
                ", id=" + id +
                ", created=" + created +
                ", updated=" + updated +
                '}';
    }
}
