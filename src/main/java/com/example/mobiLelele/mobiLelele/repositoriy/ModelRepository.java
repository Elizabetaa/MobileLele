package com.example.mobiLelele.mobiLelele.repositoriy;

import com.example.mobiLelele.mobiLelele.model.entities.ModelEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ModelRepository extends JpaRepository<ModelEntity, Long> {

    ModelEntity findByName(String model);
}
