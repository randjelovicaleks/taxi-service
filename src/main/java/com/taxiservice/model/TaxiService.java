package com.taxiservice.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class TaxiService {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "pib", nullable = false)
    private String pib;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "address", nullable = false)
    private String address;

    @Column(name = "phoneNumber", nullable = false)
    private String phoneNumber;

    @OneToMany(mappedBy = "taxiService", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Vehicle> vehicles;

    @OneToMany(mappedBy = "taxiService", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Driver> drivers;

    @OneToMany(mappedBy = "taxiService", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Customer> customers;

    @OneToMany(mappedBy = "taxiService", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Dispatcher> dispatchers;

    public TaxiService() {
    }

    public TaxiService(Long id, String pib, String name, String address, String phoneNumber) {
        this.id = id;
        this.pib = pib;
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPib() {
        return pib;
    }

    public void setPib(String pib) {
        this.pib = pib;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public List<Vehicle> getVehicles() {
        return vehicles;
    }

    public void setVehicles(List<Vehicle> vehicles) {
        this.vehicles = vehicles;
    }

    public List<Driver> getDrivers() {
        return drivers;
    }

    public void setDrivers(List<Driver> drivers) {
        this.drivers = drivers;
    }

    public List<Customer> getCustomers() {
        return customers;
    }

    public void setCustomers(List<Customer> customers) {
        this.customers = customers;
    }

    public List<Dispatcher> getDispatchers() {
        return dispatchers;
    }

    public void setDispatchers(List<Dispatcher> dispatchers) {
        this.dispatchers = dispatchers;
    }
}
