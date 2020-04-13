package com.taxiservice.model;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
public class TaxiService {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "pib", nullable = false)
    private String pib;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "address", nullable = false)
    private String address;

    @OneToMany(mappedBy = "taxiService", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<Vehicle> vehicles;

    @OneToMany(mappedBy = "taxiService", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<Driver> drivers;

    @OneToMany(mappedBy = "taxiService", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<Customer> customers;

    @OneToMany(mappedBy = "taxiService", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<Dispatcher> dispatchers;

    public TaxiService() {
    }

    public TaxiService(Long id, String pib, String name, String address) {
        this.id = id;
        this.pib = pib;
        this.name = name;
        this.address = address;
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

    public Set<Vehicle> getVehicles() {
        return vehicles;
    }

    public void setVehicles(Set<Vehicle> vehicles) {
        this.vehicles = vehicles;
    }

    public Set<Driver> getDrivers() {
        return drivers;
    }

    public void setDrivers(Set<Driver> drivers) {
        this.drivers = drivers;
    }

    public Set<Customer> getCustomers() {
        return customers;
    }

    public void setCustomers(Set<Customer> customers) {
        this.customers = customers;
    }

    public Set<Dispatcher> getDispatchers() {
        return dispatchers;
    }

    public void setDispatchers(Set<Dispatcher> dispatchers) {
        this.dispatchers = dispatchers;
    }
}
