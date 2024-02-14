package com.glcondominio.model;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;

@Getter()
@Setter()
public class Creation {
    
    private String createdBy;
    private Date createdAt;
    private String updatedBy;
    private Date updatedAt;
}
