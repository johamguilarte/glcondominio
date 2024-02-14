package com.glcondominio.repository.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.stereotype.Repository;

import com.glcondominio.auditory.CreationByToken;
import com.glcondominio.entity.ApartmentEntity;
import com.glcondominio.model.Creation;
import com.glcondominio.repository.ApartmentRepository;
import com.glcondominio.repository.dao.ApartmentRepositoryDao;

@Repository
public class ApartmentRepositoryImpl implements ApartmentRepository {
    Logger logger = LoggerFactory.getLogger(ApartmentRepositoryImpl.class);

    @Autowired
    ApartmentRepositoryDao crudRepository;

    @Autowired
    CreationByToken creationByToken;

    @Override
    public ApartmentEntity create(Jwt jwt, @NonNull ApartmentEntity entity) {
        logger.info("ApartmentRepositoryImpl.create {}", entity);
        entity.setId(null);

        Creation model = creationByToken.buildCreationByJwt(jwt);
        entity.setCreatedAt(model.getCreatedAt());
        entity.setCreatedBy(model.getCreatedBy());
        entity.setUpdatedAt(model.getUpdatedAt());
        entity.setUpdatedBy(model.getUpdatedBy());

        return this.crudRepository.save(entity);
    }

    @Override
    public ApartmentEntity update(Jwt jwt, @NonNull ApartmentEntity entity) {
        logger.info("ApartmentRepositoryImpl.update {}", entity);

        Creation model = creationByToken.buildCreationByJwt(jwt);
        entity.setUpdatedAt(model.getUpdatedAt());
        entity.setUpdatedBy(model.getUpdatedBy());

        return this.crudRepository.save(entity);
    }

    @Override
    public Iterable<ApartmentEntity> getAll() {
        logger.info("ApartmentRepositoryImpl.getAll");
        return this.crudRepository.findAll();
    }

    @Override
    public ApartmentEntity getById(@NonNull Long id) {
        logger.info("ApartmentRepositoryImpl.getById %d", id);
        return this.crudRepository.findById(id).get();
    }

    @Override
    public Boolean delete(Jwt jwt, @NonNull Long id) {
        try {
            logger.info("ApartmentRepositoryImpl.getById %d", id);
            if(this.crudRepository.existsById(id)){
                this.crudRepository.deleteById(id); 
                return true;
            }else {
                return false;
            }
        } catch (Exception e) {
            return false;
        }
        
    }
}
