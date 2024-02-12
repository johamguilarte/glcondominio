package com.glcondominio.repository.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Repository;

import com.glcondominio.entity.TowerEntity;
import com.glcondominio.repository.TowerRepository;
import com.glcondominio.repository.dao.TowerRepositoryDao;

@Repository
public class TowerRepositoryImpl implements TowerRepository {

    Logger logger = LoggerFactory.getLogger(TowerRepositoryImpl.class);

    @Autowired
    TowerRepositoryDao crudRepository;

    @Override
    public TowerEntity create(@NonNull TowerEntity entity) {
        logger.info("TowerRepositoryImpl.create {}", entity);
        entity.setId(null);
        return this.crudRepository.save(entity);
    }

    @Override
    public TowerEntity update(@NonNull TowerEntity entity) {
        logger.info("TowerRepositoryImpl.update {}", entity);
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
    public Boolean delete(@NonNull Long id) {
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
