package com.example.mobiLelele.mobiLelele.entities;

import com.example.mobiLelele.mobiLelele.entities.enumerated.Categories;

import javax.persistence.*;

@Entity
@Table(name = "users")
public class Model extends BaseEntity {

    private String name;

    @Enumerated(EnumType.STRING)
    private Categories category;

    @Column(length = 512)
    private String imageUrl;

    private int startYear;

    private Integer endYear;

    @ManyToOne(fetch = FetchType.LAZY)
    private Brand brand;

    public String getName() {
        return name;
    }

    public Model setName(String name) {
        this.name = name;
        return this;
    }

    public Categories getCategory() {
        return category;
    }

    public Model setCategory(Categories category) {
        this.category = category;
        return this;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public Model setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
        return this;
    }

    public int getStartYear() {
        return startYear;
    }

    public Model setStartYear(int startYear) {
        this.startYear = startYear;
        return this;
    }

    public Integer getEndYear() {
        return endYear;
    }

    public Model setEndYear(Integer endYear) {
        this.endYear = endYear;
        return this;
    }

//    public Brand getBrand() {
//        return brand;
//    }
//
//    public Model setBrand(Brand brand) {
//        this.brand = brand;
//        return this;
//    }

//    @Override
//    public String toString() {
//        return "ModelEntity{" +
//                "name='" + name + '\'' +
//                ", category=" + category +
//                ", imageUrl='" + imageUrl + '\'' +
//                ", startYear=" + startYear +
//                ", endYar=" + endYear +
//                ", brand=" + brand +
//                ", id=" + id +
//                ", created=" + created +
//                ", updated=" + updated +
//                '}';
//    }
}
