package com.glcondominio.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;

import com.glcondominio.entity.TownPlanningEntity;
import com.glcondominio.model.TownPlanning;
import com.glcondominio.repository.TownPlanningRepository;
import com.glcondominio.service.TownPlanningService;
import com.glcondominio.transformer.TownPlanningTransformer;

@Service
public class TownPlanningServiceImpl implements TownPlanningService {
    Logger logger = LoggerFactory.getLogger(TownPlanningServiceImpl.class);

    @Autowired
    TownPlanningRepository repository;

    @Autowired
    TownPlanningTransformer transformer;

    @SuppressWarnings("null")
    @Override
    public TownPlanning create(@NonNull TownPlanning model) {
        logger.info("TownPlanningServiceImpl.create {}", model);
        return transformer.toModel(
            this.repository.create(
                    this.transformer.toEntity(model)));
    }

    @SuppressWarnings("null")
    @Override
    public TownPlanning update(@NonNull TownPlanning model) {
        logger.info("TownPlanningServiceImpl.update {}", model);
        return transformer.toModel(
            this.repository.create(
                    this.transformer.toEntity(model)));
    }

    @Override
    public List<TownPlanning> getAll() {
        logger.info("TownPlanningServiceImpl.getAll");
       List<TownPlanningEntity> result = new ArrayList<TownPlanningEntity>();
       this.repository.getAll().forEach(result::add);
       return this.transformer.toModelList(result); 
    }

    @Override
    public TownPlanning getById(@NonNull Long id) {
        logger.info("TownPlanningServiceImpl.getById %d", id);
        return this.transformer.toModel(repository.getById(id));
    }

    @Override
    public Boolean delete(@NonNull Long id) {
        logger.info("TownPlanningServiceImpl.delete %d", id);
        return this.repository.delete(id);
    }
    
}
