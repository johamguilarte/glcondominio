package com.glcondominio.service;

import java.util.List;
import org.springframework.lang.NonNull;
import com.glcondominio.model.Tower;


public interface TowerService {

    public Tower create(@NonNull Tower model);

    public Tower update(@NonNull Tower model);

    public List<Tower> getAll();

    public Tower getById(@NonNull Long id);

    public Boolean delete(@NonNull Long id);

}