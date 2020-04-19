package com.taxiservice.dto;

import com.taxiservice.model.Driver;

public class DriverDTO {

    private Long id;
    private String username;
    private String password;
    private String name;
    private String surname;
    private String address;
    private String phoneNumber;
    private double salary;
    private String taxiCardNumber;

    public DriverDTO() {
    }

    public DriverDTO(Long id, String username, String password, String name, String surname,
                     String address, String phoneNumber, double salary, String taxiCardNumber) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.name = name;
        this.surname = surname;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.salary = salary;
        this.taxiCardNumber = taxiCardNumber;
    }

    public DriverDTO(Driver driver) {
        this.id = driver.getId();
        this.username = driver.getUsername();
        this.password = driver.getPassword();
        this.name = driver.getName();
        this.surname = driver.getSurname();
        this.address = driver.getAddress();
        this.phoneNumber = driver.getPhoneNumber();
        this.salary = driver.getSalary();
        this.taxiCardNumber = driver.getTaxiCardNumber();
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

    public String getTaxiCardNumber() {
        return taxiCardNumber;
    }

    public void setTaxiCardNumber(String taxiCardNumber) {
        this.taxiCardNumber = taxiCardNumber;
    }

}
