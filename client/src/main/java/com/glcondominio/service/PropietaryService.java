package com.glcondominio.service;

import java.util.List;
import org.springframework.lang.NonNull;
import org.springframework.security.oauth2.jwt.Jwt;
import com.glcondominio.model.Propietary;

public interface PropietaryService {

    public Propietary create(Jwt jwt, @NonNull Propietary model);

    public Propietary update(Jwt jwt, @NonNull Propietary model);

    public List<Propietary> getAll();

    public Propietary getById(@NonNull Long id);

    public Boolean delete(Jwt jwt, @NonNull Long id);
}