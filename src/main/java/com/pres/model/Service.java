package com.pres.model;

import java.util.Objects;

public class Service {

    private int id;
    private String name_unit;
    private int service_id;
    private String name_service;
    private float unit_price;


    public Service(int id, int service_id, String name_service,String name_unit, float unit_price) {
        this.id = id;
        this.service_id = service_id;
        this.name_service = name_service;
        this.name_unit = name_unit;
        this.unit_price = unit_price;
    }

    public Service(){
    }

    public String getUnit(){
        return name_unit;
    }

    public int getService_id(){
        return service_id;
    }

    public String getName_service(){
        return name_service;
    }

    public float getUnit_price(){
        return unit_price;
    }

    public int getId(){
        return id;
    }

    public void setUnit(String unit){
        this.name_unit = unit;
    }

    public void setService_id(int service_id){
        this.service_id = service_id ;
    }

    public void setName_service(String name_service){
        this.name_service = name_service;
    }

    public void setUnit_price(float unit_price){
        this.unit_price = unit_price;
    }

    public void setId(int id){
        this.id = id;
    }


    @Override
    public String toString() {
        return "Service{" +
                "id=" + id +
                ", service_id=" + service_id +
                ", name_service='" + name_service + '\'' +
                ", unit_price=" + unit_price +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Service service = (Service) o;
        return id == service.id &&
                service_id == service.service_id &&
                Float.compare(service.unit_price, unit_price) == 0 &&
                Objects.equals(name_unit, service.name_unit) &&
                Objects.equals(name_service, service.name_service);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name_unit, service_id, name_service, unit_price);
    }
}
