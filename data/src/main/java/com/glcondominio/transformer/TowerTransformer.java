package com.glcondominio.transformer;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.glcondominio.entity.TowerEntity;
import com.glcondominio.model.Tower;

@Service
public class TowerTransformer {

    @Autowired
    private ModelMapper modelMapper;

    public TowerEntity toEntity(Tower model) {
        return modelMapper.map(model, TowerEntity.class);
    }

    public Tower toModel(TowerEntity entity) {
        return modelMapper.map(entity, Tower.class);
    }

    public List<Tower> toModelList(List<TowerEntity> entity) {
        return entity
                .stream()
                .map(element -> modelMapper.map(element, Tower.class))
                .collect(Collectors.toList());
    }

    public List<TowerEntity> toEntityList(List<Tower> model) {
        return model
                .stream()
                .map(element -> modelMapper.map(element, TowerEntity.class))
                .collect(Collectors.toList());
    }

}
