package com.pres.model;

import java.util.Objects;

public class Service implements Comparable<Service>{

    private int service_id;
    private String name_service;
    private String name_unit;
    private float unit_price;
    private float amount;



    public Service(int service_id, String name_service, String name_unit, float unit_price, float amount) {
        this.service_id = service_id;
        this.name_service = name_service;
        this.name_unit = name_unit;
        this.unit_price = unit_price;
        this.amount = amount;
    }

    public Service(){
    }

    public String getName_unit(){
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

    public float getAmount() {
        return amount;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }

    public void setName_unit(String name_unit){
        this.name_unit = name_unit;
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


    @Override
    public String toString() {
        return "Service{" +
                "service_id=" + service_id +
                ", name_service='" + name_service + '\'' +
                ", name_unit='" + name_unit + '\'' +
                ", unit_price=" + unit_price +
                ", amount='" + amount + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Service service = (Service) o;
        return service_id == service.service_id &&
                Float.compare(service.unit_price, unit_price) == 0 &&
                Objects.equals(name_service, service.name_service) &&
                Objects.equals(name_unit, service.name_unit) &&
                Objects.equals(amount, service.amount);
    }


    @Override
    public int compareTo(Service o) {
        return service_id - o.service_id;
    }
}
