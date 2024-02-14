package com.glcondominio.repository.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.stereotype.Repository;

import com.glcondominio.auditory.CreationByToken;
import com.glcondominio.entity.TownPlanningEntity;
import com.glcondominio.model.Creation;
import com.glcondominio.repository.TownPlanningRepository;
import com.glcondominio.repository.dao.TownPlanningRepositoryDao;

@Repository
public class TownPlanningRepositoryImpl implements TownPlanningRepository {

    Logger logger = LoggerFactory.getLogger(TownPlanningRepositoryImpl.class);

    @Autowired
    TownPlanningRepositoryDao crudRepository;

    @Autowired
    CreationByToken creationByToken;

    @Override
    public TownPlanningEntity create(Jwt jwt, @NonNull TownPlanningEntity entity) {
        logger.info("TownPlanningRepositoryImpl.create {}", entity);
        entity.setId(null);

        Creation model = creationByToken.buildCreationByJwt(jwt);
        entity.setCreatedAt(model.getCreatedAt());
        entity.setCreatedBy(model.getCreatedBy());
        entity.setUpdatedAt(model.getUpdatedAt());
        entity.setUpdatedBy(model.getUpdatedBy());

        return this.crudRepository.save(entity);
    }

    @Override
    public TownPlanningEntity update(Jwt jwt, @NonNull TownPlanningEntity entity) {
        logger.info("TownPlanningRepositoryImpl.update {}", entity);

        Creation model = creationByToken.buildCreationByJwt(jwt);
        entity.setUpdatedAt(model.getUpdatedAt());
        entity.setUpdatedBy(model.getUpdatedBy());

        return this.crudRepository.save(entity);
    }

    @Override
    public Iterable<TownPlanningEntity> getAll() {
        logger.info("TownPlanningRepositoryImpl.getAll");
        return this.crudRepository.findAll();
    }

    @Override
    public TownPlanningEntity getById(@NonNull Long id) {
        logger.info("TownPlanningRepositoryImpl.getById %d", id);
        return this.crudRepository.findById(id).get();
    }

    @Override
    public Boolean delete(Jwt jwt, @NonNull Long id) {
        try {
            logger.info("TownPlanningRepositoryImpl.getById %d", id);
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
