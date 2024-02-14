package com.glcondominio.repository;

import org.springframework.lang.NonNull;
import org.springframework.security.oauth2.jwt.Jwt;

import com.glcondominio.entity.TownPlanningEntity;

public interface TownPlanningRepository {

   public TownPlanningEntity create(Jwt jwt, @NonNull TownPlanningEntity entity);

    public TownPlanningEntity update(Jwt jwt, @NonNull TownPlanningEntity entity);

    public Iterable<TownPlanningEntity> getAll();

    public TownPlanningEntity getById(@NonNull Long id);

    public Boolean delete(Jwt jwt, @NonNull Long id);

}
