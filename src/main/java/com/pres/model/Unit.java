package com.pres.model;

public class Unit {

    private int unit_id;
    private String name_unit;


    public Unit(int unit_id, String name_unit) {
        this.unit_id = unit_id;
        this.name_unit = name_unit;
    }

    public Unit(){}

    public String getName_unit() {
        return name_unit;
    }

    public int getUnit_id() {
        return unit_id;
    }

    public void setName_unit(String name_unit) {
        this.name_unit = name_unit;
    }

    public void setUnit_id(int unit_id) {
        this.unit_id = unit_id;
    }
}
