package com.glcondominio.entity;

import java.io.Serializable;

import com.glcondominio.model.Creation;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name="APARTMENT")
public class ApartmentEntity extends Creation implements Serializable {
    private static final long serialVersionUID = -1123914430092011471L;

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="ID")
    private Long id;

    @Column(name="NAME")
    private String name;

    @ManyToOne
    @JoinColumn(name="TOWER_ID")
    private TowerEntity tower;
}
