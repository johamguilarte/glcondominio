package com.glcondominio.repository.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.stereotype.Repository;

import com.glcondominio.auditory.CreationByToken;
import com.glcondominio.entity.PropietaryEntity;
import com.glcondominio.model.Creation;
import com.glcondominio.repository.PropietaryRepository;
import com.glcondominio.repository.dao.PropietaryRepositoryDao;

@Repository
public class PropietaryRepositoryImpl implements PropietaryRepository {

    Logger logger = LoggerFactory.getLogger(PropietaryRepositoryImpl.class);

    @Autowired
    PropietaryRepositoryDao crudRepository;

    @Autowired
    CreationByToken creationByToken;

    @Override
    public PropietaryEntity create(Jwt jwt, @NonNull PropietaryEntity entity) {
        logger.info("PropietaryRepositoryImpl.create {}", entity);
        entity.setId(null);

        Creation model = creationByToken.buildCreationByJwt(jwt);
        entity.setCreatedAt(model.getCreatedAt());
        entity.setCreatedBy(model.getCreatedBy());
        entity.setUpdatedAt(model.getUpdatedAt());
        entity.setUpdatedBy(model.getUpdatedBy());

        return this.crudRepository.save(entity);
    }

    @Override
    public PropietaryEntity update(Jwt jwt, @NonNull PropietaryEntity entity) {
        logger.info("PropietaryRepositoryImpl.update {}", entity);

        Creation model = creationByToken.buildCreationByJwt(jwt);
        entity.setUpdatedAt(model.getUpdatedAt());
        entity.setUpdatedBy(model.getUpdatedBy());

        return this.crudRepository.save(entity);
    }

    @Override
    public Iterable<PropietaryEntity> getAll() {
        logger.info("PropietaryRepositoryImpl.getAll");
        return this.crudRepository.findAll();
    }

    @Override
    public PropietaryEntity getById(@NonNull Long id) {
        logger.info("PropietaryRepositoryImpl.getById %d", id);
        return this.crudRepository.findById(id).get();
    }

    @Override
    public Boolean delete(Jwt jwt, @NonNull Long id) {
        try {
            logger.info("PropietaryRepositoryImpl.getById %d", id);
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
