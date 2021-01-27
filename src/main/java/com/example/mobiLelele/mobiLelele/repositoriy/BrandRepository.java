package com.example.mobiLelele.mobiLelele.repositoriy;

import com.example.mobiLelele.mobiLelele.model.entities.Brand;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BrandRepository extends JpaRepository<Brand, Long> {

}
