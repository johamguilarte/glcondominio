package com.glcondominio.service;

import java.util.List;
import org.springframework.lang.NonNull;
import org.springframework.security.oauth2.jwt.Jwt;

import com.glcondominio.model.TownPlanning;

public interface TownPlanningService {

    public TownPlanning create(Jwt jwt, @NonNull TownPlanning model);

    public TownPlanning update(Jwt jwt, @NonNull TownPlanning model);

    public List<TownPlanning> getAll();

    public TownPlanning getById(@NonNull Long id);

    public Boolean delete(Jwt jwt, @NonNull Long id);

}
