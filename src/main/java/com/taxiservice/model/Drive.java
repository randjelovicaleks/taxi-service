package com.taxiservice.model;

import java.util.Date;

public class Drive {

    private Long id;
    private Date orderDate;
    private String startingAddress;
    private Driver driver;
    private Customer customer;

    public Drive() {
    }

    public Drive(Long id, Date orderDate, String startingAddress) {
        this.id = id;
        this.orderDate = orderDate;
        this.startingAddress = startingAddress;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public String getStartingAddress() {
        return startingAddress;
    }

    public void setStartingAddress(String startingAddress) {
        this.startingAddress = startingAddress;
    }

    public Driver getDriver() {
        return driver;
    }

    public void setDriver(Driver driver) {
        this.driver = driver;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}
