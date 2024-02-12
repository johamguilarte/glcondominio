package com.glcondominio.model;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;

@Getter()
@Setter()
public class Creation {
    
    private Long createdBy;
    private Date createdAt;
    private Long updatedBy;
    private Date updatedAt;
}
