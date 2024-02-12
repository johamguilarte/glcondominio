package com.glcondominio.transformer;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.glcondominio.entity.TownPlanningEntity;
import com.glcondominio.model.TownPlanning;

@Service
public class TownPlanningTransformer {

    @Autowired
    private ModelMapper modelMapper;

    public TownPlanningEntity toEntity(TownPlanning model) {
        return modelMapper.map(model, TownPlanningEntity.class);
    }

    public TownPlanning toModel(TownPlanningEntity entity) {
        return modelMapper.map(entity, TownPlanning.class);
    }

    public List<TownPlanning> toModelList(List<TownPlanningEntity> entity) {
        return entity
                .stream()
                .map(element -> modelMapper.map(element, TownPlanning.class))
                .collect(Collectors.toList());
    }

    public List<TownPlanningEntity> toEntityList(List<TownPlanning> model) {
        return model
                .stream()
                .map(element -> modelMapper.map(element, TownPlanningEntity.class))
                .collect(Collectors.toList());
    }

}
