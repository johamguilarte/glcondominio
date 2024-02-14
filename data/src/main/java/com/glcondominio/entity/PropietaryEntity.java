package com.glcondominio.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import com.glcondominio.model.Creation;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name="PROPIETARY")
public class PropietaryEntity extends Creation implements Serializable {
    private static final long serialVersionUID = -6763927892928560383L;

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="ID")
    private Long id;

    @Column(name="NAME")
    private String name;

    @Column(name="FIRTSNAME")
    private String firtsName;

    @Column(name="LASTNAME")
    private String lastName;

    @Column(name="BIRTHDAY")
    private Date birthday;

    @Column(name="ALIQUOT")
    private BigDecimal aliquot;

    @Column(name="APARTAMENTS")
    private List<Long> apartaments; 
}
