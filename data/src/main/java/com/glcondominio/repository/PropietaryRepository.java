package com.glcondominio.repository;

import org.springframework.lang.NonNull;
import org.springframework.security.oauth2.jwt.Jwt;

import com.glcondominio.entity.PropietaryEntity;

public interface PropietaryRepository {

    public PropietaryEntity create(Jwt jwt, @NonNull PropietaryEntity entity);

    public PropietaryEntity update(Jwt jwt, @NonNull PropietaryEntity entity);

    public Iterable<PropietaryEntity> getAll();

    public PropietaryEntity getById(@NonNull Long id);

    public Boolean delete(Jwt jwt, @NonNull Long id);
}