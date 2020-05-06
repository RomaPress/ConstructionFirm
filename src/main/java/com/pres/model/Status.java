package com.pres.model;

public class Status {

    private int status_id;
    private  String name_status;

    public Status(int status_id, String name_status) {
        this.status_id = status_id;
        this.name_status = name_status;
    }

    public Status(){}

    public int getStatus_id() {
        return status_id;
    }

    public String getName_status() {
        return name_status;
    }

    public void setStatus_id(int status_id) {
        this.status_id = status_id;
    }

    public void setName_status(String name_status) {
        this.name_status = name_status;
    }

    @Override
    public String toString() {
        return "Status{" +
                "status_id=" + status_id +
                ", status_name='" + name_status + '\'' +
                '}';
    }
}
