package com.glcondominio.repository;

import org.springframework.lang.NonNull;

import com.glcondominio.entity.PropietaryEntity;

public interface PropietaryRepository {

    public PropietaryEntity create(@NonNull PropietaryEntity entity);

    public PropietaryEntity update(@NonNull PropietaryEntity entity);

    public Iterable<PropietaryEntity> getAll();

    public PropietaryEntity getById(@NonNull Long id);

    public Boolean delete(@NonNull Long id);
}