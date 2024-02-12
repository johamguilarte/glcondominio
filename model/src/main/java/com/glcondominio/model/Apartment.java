package com.glcondominio.model;

import lombok.Getter;
import lombok.Setter;

@Getter()
@Setter()
public class Apartment extends Creation {

    private Long id;
    private String name; //housingName
    private Long towerId;
    private Long townPlanningId;
    private Long propietaryId;
    private Long userId;    
}
