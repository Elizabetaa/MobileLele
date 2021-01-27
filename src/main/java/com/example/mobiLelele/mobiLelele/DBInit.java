package com.example.mobiLelele.mobiLelele;

import com.example.mobiLelele.mobiLelele.model.entities.BaseEntity;
import com.example.mobiLelele.mobiLelele.model.entities.Brand;
import com.example.mobiLelele.mobiLelele.model.entities.Model;
import com.example.mobiLelele.mobiLelele.model.entities.enums.Categories;
import com.example.mobiLelele.mobiLelele.repositoriy.BrandRepository;
import com.example.mobiLelele.mobiLelele.repositoriy.ModelRepository;
import org.apache.catalina.Store;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.time.Instant;
import java.util.List;

@Component
public class DBInit implements CommandLineRunner {


    private final ModelRepository modelRepository;
    private final BrandRepository brandRepository;

    public DBInit(ModelRepository modelRepository, BrandRepository brandRepository) {
        this.modelRepository = modelRepository;
        this.brandRepository = brandRepository;
    }

    @Transactional
    @Override
    public void run(String... args) throws Exception {
        Brand fordBrand = new Brand();
        fordBrand.setName("Ford");
        setCurrentTimestamp(fordBrand);


        Brand hondaBrand = new Brand();
        hondaBrand.setName("Honda");
        setCurrentTimestamp(hondaBrand);

        this.brandRepository.saveAll(List.of(hondaBrand, fordBrand));

        initFiesta(fordBrand);
        initEscort(hondaBrand);
        initNC750S(hondaBrand);
    }
    private Model initNC750S(Brand hondaBrand){
        Model NC750S = new Model();
        NC750S.setName("Escort")
                .setCategory(Categories.Motorcycle)
                .setImageUrl("https://www.motorcyclespecs.co.za/Gallery%20B/Honda%20NC750S%2014%20%207.jpg")
                .setStartYear(2014)
                .setBrand(hondaBrand);
        setCurrentTimestamp(NC750S);
        return modelRepository.save(NC750S);
    }

    private Model initEscort(Brand hondaBrand) {
        Model escort = new Model();
        escort.setName("Escort")
                .setCategory(Categories.Car)
                .setImageUrl("https://cdna.artstation.com/p/assets/images/images/008/654/944/large/kiran-r-1970-ford-escort-cosworth-4.jpg?1514316558")
                .setStartYear(1968)
                .setEndYear(2002)
                .setBrand(hondaBrand);
        setCurrentTimestamp(escort);
        return modelRepository.save(escort);
    }

    private Model initFiesta(Brand fordBrand) {
        Model fiesta = new Model();
        fiesta.setName("Fiesta")
                .setCategory(Categories.Car)
                .setImageUrl("https://cdn3.focus.bg/autodata/i/ford/fiesta/fiesta-vi-mk7-mk8/medium/5f95f6ee7628df63ef880d8f3ac91f3a.jpg")
                .setStartYear(1976)
                .setEndYear(null)
                .setBrand(fordBrand);
        setCurrentTimestamp(fiesta);
        return modelRepository.save(fiesta);
    }

    private static void setCurrentTimestamp(BaseEntity baseEntity) {
        baseEntity.setCreated(Instant.now())
                .setUpdated(Instant.now());
    }
}
