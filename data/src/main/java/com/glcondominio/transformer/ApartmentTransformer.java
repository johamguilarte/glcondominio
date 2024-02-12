package com.glcondominio.transformer;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.glcondominio.entity.ApartmentEntity;
import com.glcondominio.model.Apartment;

@Service
public class ApartmentTransformer {

    @Autowired
    private ModelMapper modelMapper;

    public ApartmentEntity toEntity(Apartment model) {
        return modelMapper.map(model, ApartmentEntity.class);
    }

    public Apartment toModel(ApartmentEntity entity) {
        return modelMapper.map(entity, Apartment.class);
    }

    public List<Apartment> toModelList(List<ApartmentEntity> entity) {
        return entity
                .stream()
                .map(element -> modelMapper.map(element, Apartment.class))
                .collect(Collectors.toList());
    }

    public List<ApartmentEntity> toEntityList(List<Apartment> model) {
        return model
                .stream()
                .map(element -> modelMapper.map(element, ApartmentEntity.class))
                .collect(Collectors.toList());
    }

}
