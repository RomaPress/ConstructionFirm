package com.pres.model;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class Order extends Customer {

    private int order_id;
    private Date data;
    private String status;
    private List<Service> orderedServices;
    private float price;

    public Order( int customer_id, String first_name, String last_name, String patronymic, int phone_number,int order_id, Date data, String status, List<Service> orderedServices, float price){
        super(customer_id, first_name, last_name, patronymic, phone_number);
        this.order_id = order_id;
        this.data = data;
        this.status = status;
        this.orderedServices = orderedServices;
        this.price = price;
    }

    public Order(){
        super();
    }

    public int getOrder_id() {
        return order_id;
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

    public String getData() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        return dateFormat.format(data);
    }

    public String getStatus() {
        return status;
    }

    public List<Service> getOrderedServices() {
        return orderedServices;
    }

    public float getPrice() {
        return price;
    }

    public void setOrder_id(int order_id) {
        this.order_id = order_id;
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

    public void setData(Date data) {
       this.data = data;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setOrderedServices(List<Service> orderedServices) {
        this.orderedServices = orderedServices;
    }

    public void setPrice(float price) {
        this.price = price;
    }


    @Override
    public String toString() {
        System.out.println("_________________________");
        System.out.println("data='" + data + '\'');
        System.out.println("status='" + status + '\'');
        System.out.println("orderedServices=" + orderedServices);
        System.out.println("price=" + price);
        System.out.println("first_name='" + first_name + '\'');
        System.out.println("last_name='" + last_name + '\'');
        System.out.println("patronymic='" + patronymic + '\'');
        System.out.println("phone_number=" + phone_number);
        System.out.println("customer_id=" + customer_id);

        return "Order{" +
                "data='" + data + '\'' +
                ", status='" + status + '\'' +
                ", orderedServices=" + orderedServices +
                ", price=" + price +
                ", first_name='" + first_name + '\'' +
                ", last_name='" + last_name + '\'' +
                ", patronymic='" + patronymic + '\'' +
                ", phone_number=" + phone_number +
                ", customer_id=" + customer_id +
                '}';
    }
}
