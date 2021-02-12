package com.example.mobiLelele.mobiLelele.model.view;

import com.example.mobiLelele.mobiLelele.model.entities.Brand;
import com.example.mobiLelele.mobiLelele.model.entities.enums.Categories;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ManyToOne;

public class ModelViewModel {

    private long id;
    private String name;
    private Categories category;
    private String imageUrl;
    private int startYear;
    private Integer endYear;

    public String getName() {
        return name;
    }

    public ModelViewModel setName(String name) {
        this.name = name;
        return this;
    }

    public Categories getCategory() {
        return category;
    }

    public ModelViewModel setCategory(Categories category) {
        this.category = category;
        return this;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public ModelViewModel setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
        return this;
    }

    public int getStartYear() {
        return startYear;
    }

    public ModelViewModel setStartYear(int startYear) {
        this.startYear = startYear;
        return this;
    }

    public Integer getEndYear() {
        return endYear;
    }

    public ModelViewModel setEndYear(Integer endYear) {
        this.endYear = endYear;
        return this;
    }

    public long getId() {
        return id;
    }

    public ModelViewModel setId(long id) {
        this.id = id;
        return this;
    }

    @Override
    public String toString() {
        return "ModelViewModel{" +
                "name='" + name + '\'' +
                ", category=" + category +
                ", imageUrl='" + imageUrl + '\'' +
                ", startYear=" + startYear +
                ", endYear=" + endYear +
                '}';
    }
}
