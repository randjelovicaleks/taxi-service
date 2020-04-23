package com.taxiservice.model;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Drive {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "orderDate", nullable = false)
    private Date orderDate;

    @Column(name = "startingAddress", nullable = false)
    private String startingAddress;

    @ManyToOne(cascade = { CascadeType.MERGE, CascadeType.PERSIST }, fetch = FetchType.EAGER)
    private Driver driver;

    @ManyToOne(cascade = { CascadeType.MERGE, CascadeType.PERSIST }, fetch = FetchType.EAGER)
    private Customer customer; //za voznje koje se kreiraju putem aplikacije

    @ManyToOne(cascade = { CascadeType.MERGE, CascadeType.PERSIST }, fetch = FetchType.EAGER)
    private Dispatcher dispatcher;

    @Column(name = "note")
    private String note;

    @Column(name = "customerName")
    private String customerName; //za voznje koje se kreiraju putem telefonskog poziva

    @Column(name = "price")
    private double price;

    public Drive() {
    }

    public Drive(Long id, Date orderDate, String startingAddress, Driver driver, Customer customer,
                 Dispatcher dispatcher, String note, String customerName, double price) {
        this.id = id;
        this.orderDate = orderDate;
        this.startingAddress = startingAddress;
        this.driver = driver;
        this.customer = customer;
        this.dispatcher = dispatcher;
        this.note = note;
        this.customerName = customerName;
        this.price = price;
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

    public Dispatcher getDispatcher() {
        return dispatcher;
    }

    public void setDispatcher(Dispatcher dispatcher) {
        this.dispatcher = dispatcher;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
