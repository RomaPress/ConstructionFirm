package com.pres.model;

public class Customer {

    private String first_name;
    private String last_name;
    private String patronymic;
    private int phone_number;
    private int customer_id;

    public Customer (String first_name, String last_name, String patronymic, int phone_number){
        this.first_name = first_name;
        this.last_name = last_name;
        this.patronymic = patronymic;
        this.phone_number = phone_number;
    }

    public Customer(){

    }



    public int getCustomer_id() {
        return customer_id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public int getPhone_number() {
        return phone_number;
    }

    public void setCustomer_id(int customer_id) {
        this.customer_id = customer_id;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public void setPhone_number(int phone_number) {
        this.phone_number = phone_number;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "first_name='" + first_name + '\'' +
                ", last_name='" + last_name + '\'' +
                ", patronymic='" + patronymic + '\'' +
                ", phone_number=" + phone_number +
                ", customer_id=" + customer_id +
                '}';
    }
}
