package com.glcondominio.entity;

import java.io.Serializable;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name="TOWN_PLANNING")
public class TownPlanningEntity implements Serializable {
    private static final long serialVersionUID = -4991133276610620956L;

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="ID")
    private Long id;

    @Column(name="NAME", nullable=false)
    private String name;

    @Column(name="PERMISSIONS")
    private List<Long> permission;

    @OneToMany(mappedBy = "townPlanning")
    private List<TowerEntity> tower;
}
