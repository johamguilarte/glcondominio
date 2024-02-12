package com.glcondominio.transformer;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.glcondominio.entity.PropietaryEntity;
import com.glcondominio.model.Propietary;

@Service
public class PropietaryTransformer {

    @Autowired
    private ModelMapper modelMapper;

    public PropietaryEntity toEntity(Propietary model) {
        return modelMapper.map(model, PropietaryEntity.class);
    }

    public Propietary toModel(PropietaryEntity entity) {
        return modelMapper.map(entity, Propietary.class);
    }

    public List<Propietary> toModelList(List<PropietaryEntity> entity) {
        return entity
                .stream()
                .map(element -> modelMapper.map(element, Propietary.class))
                .collect(Collectors.toList());
    }

    public List<PropietaryEntity> toEntityList(List<Propietary> model) {
        return model
                .stream()
                .map(element -> modelMapper.map(element, PropietaryEntity.class))
                .collect(Collectors.toList());
    }

}
