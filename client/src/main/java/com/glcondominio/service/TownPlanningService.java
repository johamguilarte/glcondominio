package com.glcondominio.service;

import java.util.List;
import org.springframework.lang.NonNull;
import com.glcondominio.model.TownPlanning;

public interface TownPlanningService {

    public TownPlanning create(@NonNull TownPlanning model);

    public TownPlanning update(@NonNull TownPlanning model);

    public List<TownPlanning> getAll();

    public TownPlanning getById(@NonNull Long id);

    public Boolean delete(@NonNull Long id);

}
