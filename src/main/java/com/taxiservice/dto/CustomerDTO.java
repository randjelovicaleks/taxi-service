package com.taxiservice.dto;

import com.taxiservice.model.Customer;

public class CustomerDTO {

    private Long id;
    private String username;
    private String password;
    private String name;
    private String surname;
    private String address;
    private String phoneNumber;

    public CustomerDTO() {
    }

    public CustomerDTO(Long id, String username, String password, String name, String surname, String address,
                       String phoneNumber) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.name = name;
        this.surname = surname;
        this.address = address;
        this.phoneNumber = phoneNumber;
    }

    public CustomerDTO(Customer customer) {
        this.id = customer.getId();
        this.username = customer.getUsername();
        this.password = customer.getPassword();
        this.name = customer.getName();
        this.surname = customer.getSurname();
        this.address = customer.getAddress();
        this.phoneNumber = customer.getPhoneNumber();

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
}
