package com.glcondominio.model;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter()
@Setter()
public class Propietary extends Creation {
    private Long id;
    private String firtsName;
    private String lastName;
    private Date birthday;
    private BigDecimal aliquot;
    private List<Long> apartaments; //esto se debe revisar
    private Long userId;
}
