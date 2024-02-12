package com.glcondominio.repository;

import org.springframework.lang.NonNull;
import com.glcondominio.entity.ApartmentEntity;

public interface ApartmentRepository {
    
    public ApartmentEntity create(@NonNull ApartmentEntity entity);

    public ApartmentEntity update(@NonNull ApartmentEntity entity);

    public Iterable<ApartmentEntity> getAll();

    public ApartmentEntity getById(@NonNull Long id);

    public Boolean delete(@NonNull Long id);

}
