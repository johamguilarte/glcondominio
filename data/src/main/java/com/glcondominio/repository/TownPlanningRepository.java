package com.glcondominio.repository;

import org.springframework.lang.NonNull;

import com.glcondominio.entity.TownPlanningEntity;

public interface TownPlanningRepository {

   public TownPlanningEntity create(@NonNull TownPlanningEntity entity);

    public TownPlanningEntity update(@NonNull TownPlanningEntity entity);

    public Iterable<TownPlanningEntity> getAll();

    public TownPlanningEntity getById(@NonNull Long id);

    public Boolean delete(@NonNull Long id);

}
