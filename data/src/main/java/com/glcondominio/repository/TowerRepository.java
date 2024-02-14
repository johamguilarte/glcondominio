package com.glcondominio.repository;

import org.springframework.lang.NonNull;
import org.springframework.security.oauth2.jwt.Jwt;

import com.glcondominio.entity.TowerEntity;

public interface TowerRepository {

    public TowerEntity create(Jwt jwt, @NonNull TowerEntity entity);

    public TowerEntity update(Jwt jwt, @NonNull TowerEntity entity);

    public Iterable<TowerEntity> getAll();

    public TowerEntity getById(@NonNull Long id);

    public Boolean delete(Jwt jwt, @NonNull Long id);

}