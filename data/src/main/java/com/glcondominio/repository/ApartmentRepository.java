package com.glcondominio.repository;

import org.springframework.lang.NonNull;
import org.springframework.security.oauth2.jwt.Jwt;

import com.glcondominio.entity.ApartmentEntity;

public interface ApartmentRepository {
    
    public ApartmentEntity create(Jwt jwt, @NonNull ApartmentEntity entity);

    public ApartmentEntity update(Jwt jwt, @NonNull ApartmentEntity entity);

    public Iterable<ApartmentEntity> getAll();

    public ApartmentEntity getById(@NonNull Long id);

    public Boolean delete(Jwt jwt, @NonNull Long id);

}
