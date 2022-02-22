package com.bbo.model;

import io.quarkus.hibernate.orm.panache.PanacheEntity;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.util.List;

@Entity
public class Fruit extends PanacheEntity {

    public String name;
    @Enumerated(EnumType.STRING)
    public Season season;


}
