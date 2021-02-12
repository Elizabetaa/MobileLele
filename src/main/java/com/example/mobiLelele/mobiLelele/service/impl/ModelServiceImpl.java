package com.example.mobiLelele.mobiLelele.service.impl;

import com.example.mobiLelele.mobiLelele.model.entities.ModelEntity;
import com.example.mobiLelele.mobiLelele.repositoriy.ModelRepository;
import com.example.mobiLelele.mobiLelele.service.ModelService;
import org.springframework.stereotype.Service;

@Service
public class ModelServiceImpl implements ModelService {
    private final ModelRepository modelRepository;

    public ModelServiceImpl(ModelRepository modelRepository) {
        this.modelRepository = modelRepository;
    }

    @Override
    public ModelEntity findById(Long id) {
        return modelRepository.findById(id).orElse(null);
    }
}
