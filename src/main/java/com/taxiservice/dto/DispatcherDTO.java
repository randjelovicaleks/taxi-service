package com.taxiservice.dto;

import com.taxiservice.model.Dispatcher;

public class DispatcherDTO {

    private Long id;
    private String username;
    private String password;
    private String name;
    private String surname;
    private String jmbg;
    private String address;
    private String phoneNumber;
    private double salary;
    //private TaxiService taxiService;

    public DispatcherDTO() {
    }

    public DispatcherDTO(Long id, String username, String password, String name, String surname, String jmbg,
                         String address, String phoneNumber, double salary) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.name = name;
        this.surname = surname;
        this.jmbg = jmbg;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.salary = salary;

    }

    public DispatcherDTO(Dispatcher dispatcher) {
        this.id = dispatcher.getId();
        this.username = dispatcher.getUsername();
        this.password = dispatcher.getPassword();
        this.name = dispatcher.getName();
        this.surname = dispatcher.getSurname();
        this.jmbg = dispatcher.getJmbg();
        this.address = dispatcher.getAddress();
        this.phoneNumber = dispatcher.getPhoneNumber();
        this.salary = dispatcher.getSalary();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getJmbg() {
        return jmbg;
    }

    public void setJmbg(String jmbg) {
        this.jmbg = jmbg;
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

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

}
