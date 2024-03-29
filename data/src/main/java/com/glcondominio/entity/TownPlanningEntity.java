package com.glcondominio.entity;

import java.io.Serializable;
import java.util.List;

import com.glcondominio.model.Creation;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name="TOWN_PLANNING")
public class TownPlanningEntity extends Creation implements Serializable {
    private static final long serialVersionUID = -4991133276610620956L;

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;

    private String name;

    private List<Long> permission;

    @OneToMany(mappedBy = "townPlanning")
    private List<TowerEntity> tower;
}
