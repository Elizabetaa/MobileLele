package com.example.mobiLelele.mobiLelele.repositoriy;

import com.example.mobiLelele.mobiLelele.model.entities.Offer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OfferRepository extends JpaRepository<Offer,Long> {

}
