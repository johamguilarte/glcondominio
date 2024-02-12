package com.glcondominio.repository.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Repository;

import com.glcondominio.entity.PropietaryEntity;
import com.glcondominio.repository.PropietaryRepository;
import com.glcondominio.repository.dao.PropietaryRepositoryDao;

@Repository
public class PropietaryRepositoryImpl implements PropietaryRepository {

    Logger logger = LoggerFactory.getLogger(PropietaryRepositoryImpl.class);

    @Autowired
    PropietaryRepositoryDao crudRepository;

    @Override
    public PropietaryEntity create(@NonNull PropietaryEntity entity) {
        logger.info("ApartmentRepositoryImpl.create {}", entity);
        entity.setId(null);
        return this.crudRepository.save(entity);
    }

    @Override
    public PropietaryEntity update(@NonNull PropietaryEntity entity) {
        logger.info("ApartmentRepositoryImpl.update {}", entity);
        return this.crudRepository.save(entity);
    }

    @Override
    public Iterable<PropietaryEntity> getAll() {
        logger.info("ApartmentRepositoryImpl.getAll");
        return this.crudRepository.findAll();
    }

    @Override
    public PropietaryEntity getById(@NonNull Long id) {
        logger.info("ApartmentRepositoryImpl.getById %d", id);
        return this.crudRepository.findById(id).get();
    }

    @Override
    public Boolean delete(@NonNull Long id) {
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
