package com.glcondominio.service;

import java.util.List;
import org.springframework.lang.NonNull;
import com.glcondominio.model.Propietary;

public interface PropietaryService {

    public Propietary create(@NonNull Propietary model);

    public Propietary update(@NonNull Propietary model);

    public List<Propietary> getAll();

    public Propietary getById(@NonNull Long id);

    public Boolean delete(@NonNull Long id);
}