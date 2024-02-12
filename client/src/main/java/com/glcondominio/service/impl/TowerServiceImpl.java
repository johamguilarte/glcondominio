package com.glcondominio.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;

import com.glcondominio.entity.TowerEntity;
import com.glcondominio.model.Tower;
import com.glcondominio.repository.TowerRepository;
import com.glcondominio.service.TowerService;
import com.glcondominio.transformer.TowerTransformer;

@Service
public class TowerServiceImpl implements TowerService {
    Logger logger = LoggerFactory.getLogger(TowerServiceImpl.class);

    @Autowired
    TowerRepository repository;

    @Autowired
    TowerTransformer transformer;

    @SuppressWarnings("null")
    @Override
    public Tower create(@NonNull Tower model) {
        logger.info("TowerServiceImpl.create {}", model);
        return transformer.toModel(
            this.repository.create(
                    this.transformer.toEntity(model)));
    }

    @SuppressWarnings("null")
    @Override
    public Tower update(@NonNull Tower model) {
        logger.info("TowerServiceImpl.update {}", model);
        return transformer.toModel(
            this.repository.create(
                    this.transformer.toEntity(model)));
    }

    @Override
    public List<Tower> getAll() {
        logger.info("TowerServiceImpl.getAll");
       List<TowerEntity> result = new ArrayList<TowerEntity>();
       this.repository.getAll().forEach(result::add);
       return this.transformer.toModelList(result); 
    }

    @Override
    public Tower getById(@NonNull Long id) {
        logger.info("TowerServiceImpl.getById %d", id);
        return this.transformer.toModel(repository.getById(id));
    }

    @Override
    public Boolean delete(@NonNull Long id) {
        logger.info("TowerServiceImpl.delete %d", id);
        return this.repository.delete(id);
    }
    
}
