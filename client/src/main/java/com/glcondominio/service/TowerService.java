package com.glcondominio.service;

import java.util.List;
import org.springframework.lang.NonNull;
import org.springframework.security.oauth2.jwt.Jwt;
import com.glcondominio.model.Tower;


public interface TowerService {

    public Tower create(Jwt jwt, @NonNull Tower model);

    public Tower update(Jwt jwt, @NonNull Tower model);

    public List<Tower> getAll();

    public Tower getById(@NonNull Long id);

    public Boolean delete(Jwt jwt, @NonNull Long id);

}