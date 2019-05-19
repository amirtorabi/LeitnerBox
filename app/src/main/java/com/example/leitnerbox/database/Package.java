package com.example.leitnerbox.database;

import io.objectbox.annotation.Entity;
import io.objectbox.annotation.Id;

@Entity
public class Package {

    @Id
    private long id;
    private String name;
    private Integer label_color;

    public Package() {
    }

    public Package(String name, Integer label_color) {

        this.name = name;
        this.label_color = label_color;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getLabel_color() {
        return label_color;
    }

    public void setLabel_color(Integer label_color) {
        this.label_color = label_color;
    }
}
