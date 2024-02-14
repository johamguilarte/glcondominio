package com.glcondominio.model;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter()
@Setter()
public class TownPlanning {
    private Long id;
    private String name;
    private List<Long> permission;
}
