package com.glcondominio.repository;

import org.springframework.lang.NonNull;

import com.glcondominio.entity.TowerEntity;

public interface TowerRepository {

    public TowerEntity create(@NonNull TowerEntity entity);

    public TowerEntity update(@NonNull TowerEntity entity);

    public Iterable<TowerEntity> getAll();

    public TowerEntity getById(@NonNull Long id);

    public Boolean delete(@NonNull Long id);

}