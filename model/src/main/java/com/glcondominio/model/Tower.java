package com.glcondominio.model;

import lombok.Getter;
import lombok.Setter;

@Getter()
@Setter()
public class Tower extends Creation {
    
    private Long id;
    private String name;
    private TownPlanning townPlanningId;

}
