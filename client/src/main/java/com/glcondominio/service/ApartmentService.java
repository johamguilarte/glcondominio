package com.glcondominio.service;

import java.util.List;
import org.springframework.lang.NonNull;
import com.glcondominio.model.Apartment;

public interface ApartmentService {
    
    public Apartment create(@NonNull Apartment model);

    public Apartment update(@NonNull Apartment model);

    public List<Apartment> getAll();

    public Apartment getById(@NonNull Long id);

    public Boolean delete(@NonNull Long id);

}
