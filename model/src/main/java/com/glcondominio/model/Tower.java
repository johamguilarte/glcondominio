package com.glcondominio.model;

import lombok.Getter;
import lombok.Setter;

@Getter()
@Setter()
public class Tower {
    
    private Long id;
    private String name;
    private TownPlanning townPlanningId;

}
