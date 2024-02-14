package com.glcondominio.repository.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.stereotype.Repository;

import com.glcondominio.auditory.CreationByToken;
import com.glcondominio.entity.TowerEntity;
import com.glcondominio.model.Creation;
import com.glcondominio.repository.TowerRepository;
import com.glcondominio.repository.dao.TowerRepositoryDao;

@Repository
public class TowerRepositoryImpl implements TowerRepository {

    Logger logger = LoggerFactory.getLogger(TowerRepositoryImpl.class);

    @Autowired
    TowerRepositoryDao crudRepository;

    @Autowired
    CreationByToken creationByToken;

    @Override
    public TowerEntity create(Jwt jwt, @NonNull TowerEntity entity) {
        logger.info("TowerRepositoryImpl.create {}", entity);
        entity.setId(null);

        Creation model = creationByToken.buildCreationByJwt(jwt);
        entity.setCreatedAt(model.getCreatedAt());
        entity.setCreatedBy(model.getCreatedBy());
        entity.setUpdatedAt(model.getUpdatedAt());
        entity.setUpdatedBy(model.getUpdatedBy());

        return this.crudRepository.save(entity);
    }

    @Override
    public TowerEntity update(Jwt jwt, @NonNull TowerEntity entity) {
        logger.info("TowerRepositoryImpl.update {}", entity);

        Creation model = creationByToken.buildCreationByJwt(jwt);
        entity.setUpdatedAt(model.getUpdatedAt());
        entity.setUpdatedBy(model.getUpdatedBy());

        return this.crudRepository.save(entity);
    }

    @Override
    public Iterable<TowerEntity> getAll() {
        logger.info("TowerRepositoryImpl.getAll");
        return this.crudRepository.findAll();
    }

    @Override
    public TowerEntity getById(@NonNull Long id) {
        logger.info("TowerRepositoryImpl.getById %d", id);
        return this.crudRepository.findById(id).get();
    }

    @Override
    public Boolean delete(Jwt jwt, @NonNull Long id) {
        try {
            logger.info("TowerRepositoryImpl.getById %d", id);
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
