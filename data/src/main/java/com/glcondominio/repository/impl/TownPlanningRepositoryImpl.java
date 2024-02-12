package com.glcondominio.repository.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Repository;

import com.glcondominio.entity.TownPlanningEntity;
import com.glcondominio.repository.TownPlanningRepository;
import com.glcondominio.repository.dao.TownPlanningRepositoryDao;

@Repository
public class TownPlanningRepositoryImpl implements TownPlanningRepository {

    Logger logger = LoggerFactory.getLogger(TownPlanningRepositoryImpl.class);

    @Autowired
    TownPlanningRepositoryDao crudRepository;

    @Override
    public TownPlanningEntity create(@NonNull TownPlanningEntity entity) {
        logger.info("TownPlanningRepositoryImpl.create {}", entity);
        entity.setId(null);
        return this.crudRepository.save(entity);
    }

    @Override
    public TownPlanningEntity update(@NonNull TownPlanningEntity entity) {
        logger.info("TownPlanningRepositoryImpl.update {}", entity);
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
    public Boolean delete(@NonNull Long id) {
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
