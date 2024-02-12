package com.glcondominio.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name="PROPIETARY")
public class PropietaryEntity implements Serializable {
    private static final long serialVersionUID = -6763927892928560383L;

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="ID")
    private Long id;

    @Column(name="NAME", nullable=true)
    private String name;

    @Column(name="FIRTSNAME", nullable=true)
    private String firtsName;

    @Column(name="LASTNAME", nullable=true)
    private String lastName;

    @Column(name="BIRTHDAY", nullable=true)
    private Date birthday;

    @Column(name="ALIQUOT", nullable=false)
    private BigDecimal aliquot;

    @Column(name="APARTAMENTS", nullable=false)
    private List<Long> apartaments; 
}
