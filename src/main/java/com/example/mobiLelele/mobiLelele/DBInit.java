package com.example.mobiLelele.mobiLelele;

import com.example.mobiLelele.mobiLelele.model.entities.BaseEntity;
import com.example.mobiLelele.mobiLelele.model.entities.Brand;
import com.example.mobiLelele.mobiLelele.model.entities.Model;
import com.example.mobiLelele.mobiLelele.model.entities.Offer;
import com.example.mobiLelele.mobiLelele.model.entities.enums.Categories;
import com.example.mobiLelele.mobiLelele.model.entities.enums.Engines;
import com.example.mobiLelele.mobiLelele.model.entities.enums.Transmissions;
import com.example.mobiLelele.mobiLelele.repositoriy.BrandRepository;
import com.example.mobiLelele.mobiLelele.repositoriy.ModelRepository;
import com.example.mobiLelele.mobiLelele.repositoriy.OfferRepository;
import org.apache.catalina.Store;
import org.dom4j.rule.Mode;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.time.Instant;
import java.util.List;

@Component
public class DBInit implements CommandLineRunner {


    private final ModelRepository modelRepository;
    private final BrandRepository brandRepository;
    private final OfferRepository offerRepository;

    public DBInit(ModelRepository modelRepository, BrandRepository brandRepository, OfferRepository offerRepository) {
        this.modelRepository = modelRepository;
        this.brandRepository = brandRepository;
        this.offerRepository = offerRepository;
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

        Model fiestaModel = initFiesta(fordBrand);
        Model escortModel = initEscort(hondaBrand);
        initNC750S(hondaBrand);
        createFiestaOffer(fiestaModel);
        createHondaOffer(escortModel);

    }
    private void createHondaOffer(Model model) {
        Offer hondaOffer = new Offer();

        hondaOffer.setEngine(Engines.DIESEL)
                .setImageUrl("https://upload.wikimedia.org/wikipedia/commons/thumb/3/39/Ford_Escort_RS2000_MkI.jpg/280px-Ford_Escort_RS2000_MkI.jpg")
                .setMileage(100000)
                .setPrice(BigDecimal.valueOf(10000))
                .setYear(1967)
                .setDescription("It's fought every day.")
                .setTransmission(Transmissions.MANUAL)
                .setModel(model);

        setCurrentTimestamp(hondaOffer);

        offerRepository.save(hondaOffer);
    }

    private void createFiestaOffer(Model model) {
        Offer fiestaOffer = new Offer();

        fiestaOffer.setEngine(Engines.GASOLINE)
                .setImageUrl("https://media.autoexpress.co.uk/image/private/s--4EbSCqe---/v1562246601/autoexpress/2018/07/1fiestast.jpg")
                .setMileage(40000)
                .setPrice(BigDecimal.valueOf(10000))
                .setYear(2019)
                .setDescription("It's fought every day. In the winter is in garage.")
                .setTransmission(Transmissions.MANUAL)
                .setModel(model);

        setCurrentTimestamp(fiestaOffer);

        offerRepository.save(fiestaOffer);
    }

    private Model initNC750S(Brand hondaBrand) {
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
