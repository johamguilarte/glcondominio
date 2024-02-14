package com.glcondominio.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.stereotype.Service;

import com.glcondominio.entity.ApartmentEntity;
import com.glcondominio.model.Apartment;
import com.glcondominio.repository.ApartmentRepository;
import com.glcondominio.service.ApartmentService;
import com.glcondominio.transformer.ApartmentTransformer;

@Service
public class ApartmentServiceImpl implements ApartmentService {
    Logger logger = LoggerFactory.getLogger(ApartmentServiceImpl.class);

    @Autowired
    ApartmentRepository repository;

    @Autowired
    ApartmentTransformer transformer;

     @SuppressWarnings("null")
    @Override
    public Apartment create(Jwt jwt, @NonNull Apartment model) {
        logger.info("ApartmentServiceImpl.create {}", model);

        return transformer.toModel(
                this.repository.create(jwt,
                        this.transformer.toEntity(model)));
    }

    @SuppressWarnings("null")
    @Override
    public Apartment update(Jwt jwt, @NonNull Apartment model) {
        logger.info("ApartmentServiceImpl.update {}", model);
        return transformer.toModel(
                this.repository.update(jwt,
                        this.transformer.toEntity(model)));
    }

    @Override
    public List<Apartment> getAll() {
        logger.info("ApartmentServiceImpl.getAll");
        List<ApartmentEntity> result = new ArrayList<ApartmentEntity>();
        this.repository.getAll().forEach(result::add);
        return this.transformer.toModelList(result);
    }

    @Override
    public Apartment getById( @NonNull Long id) {
        logger.info("ApartmentServiceImpl.getById %d", id);
        return this.transformer.toModel(repository.getById(id));
    }

    @Override
    public Boolean delete(Jwt jwt, @NonNull Long id) {
        logger.info("ApartmentServiceImpl.delete %d", id);
        return this.repository.delete(jwt, id);
    }
}
