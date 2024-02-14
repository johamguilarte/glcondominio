package com.glcondominio.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.stereotype.Service;

import com.glcondominio.entity.PropietaryEntity;
import com.glcondominio.model.Propietary;
import com.glcondominio.repository.PropietaryRepository;
import com.glcondominio.service.PropietaryService;
import com.glcondominio.transformer.PropietaryTransformer;

@Service
public class PropietaryServiceImpl implements PropietaryService {
    Logger logger = LoggerFactory.getLogger(PropietaryServiceImpl.class);

    @Autowired
    PropietaryRepository repository;

    @Autowired
    PropietaryTransformer transformer;

    @SuppressWarnings("null")
    @Override
    public Propietary create(Jwt jwt, @NonNull Propietary model) {
        logger.info("PropietaryServiceImpl.create {}", model);

        return transformer.toModel(
                this.repository.create(jwt,
                        this.transformer.toEntity(model)));
    }

    @SuppressWarnings("null")
    @Override
    public Propietary update(Jwt jwt, @NonNull Propietary model) {
        logger.info("PropietaryServiceImpl.update {}", model);
        return transformer.toModel(
                this.repository.update(jwt,
                        this.transformer.toEntity(model)));
    }

    @Override
    public List<Propietary> getAll() {
        logger.info("PropietaryServiceImpl.getAll");
        List<PropietaryEntity> result = new ArrayList<PropietaryEntity>();
        this.repository.getAll().forEach(result::add);
        return this.transformer.toModelList(result);
    }

    @Override
    public Propietary getById(@NonNull Long id) {
        logger.info("PropietaryServiceImpl.getById %d", id);
        return this.transformer.toModel(repository.getById(id));
    }

    @Override
    public Boolean delete(Jwt jwt, @NonNull Long id) {
        logger.info("PropietaryServiceImpl.delete %d", id);
        return this.repository.delete(jwt, id);
    }

}
