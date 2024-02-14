package com.glcondominio.entity;

import java.io.Serializable;
import java.util.List;

import com.glcondominio.model.Creation;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name="TOWER")
public class TowerEntity extends Creation implements Serializable {
    private static final long serialVersionUID = -7468329558815955367L;

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="ID")
    private Long id;

    @Column(name="NAME")
    private String name;

    @ManyToOne
    @JoinColumn(name="TOWN_PLANNING_ID")
    private TownPlanningEntity townPlanning;

    @OneToMany(mappedBy = "tower")
    private List<ApartmentEntity> apartment;
}
