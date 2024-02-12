package com.glcondominio.repository.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Repository;

import com.glcondominio.entity.ApartmentEntity;
import com.glcondominio.repository.ApartmentRepository;
import com.glcondominio.repository.dao.ApartmentRepositoryDao;

@Repository
public class ApartmentRepositoryImpl implements ApartmentRepository {
    Logger logger = LoggerFactory.getLogger(ApartmentRepositoryImpl.class);

    @Autowired
    ApartmentRepositoryDao crudRepository;

    @Override
    public ApartmentEntity create(@NonNull ApartmentEntity entity) {
        logger.info("ApartmentRepositoryImpl.create {}", entity);
        entity.setId(null);
        return this.crudRepository.save(entity);
    }

    @Override
    public ApartmentEntity update(@NonNull ApartmentEntity entity) {
        logger.info("ApartmentRepositoryImpl.update {}", entity);
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
