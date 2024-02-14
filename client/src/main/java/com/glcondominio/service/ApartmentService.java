package com.glcondominio.service;

import java.util.List;
import org.springframework.lang.NonNull;
import org.springframework.security.oauth2.jwt.Jwt;

import com.glcondominio.model.Apartment;

public interface ApartmentService {
    
    public Apartment create(Jwt jwt, @NonNull Apartment model);

    public Apartment update(Jwt jwt, @NonNull Apartment model);

    public List<Apartment> getAll();

    public Apartment getById(@NonNull Long id);

    public Boolean delete(Jwt jwt, @NonNull Long id);
}