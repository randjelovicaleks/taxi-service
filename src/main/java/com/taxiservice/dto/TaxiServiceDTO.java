package com.taxiservice.dto;

import com.taxiservice.model.TaxiService;

public class TaxiServiceDTO {

    private Long id;
    private String pib; //mozda ne treba
    private String name;
    private String address;
    private String phoneNumber;

    public TaxiServiceDTO() {
    }

    public TaxiServiceDTO(Long id, String pib, String name, String address, String phoneNumber) {
        this.id = id;
        this.pib = pib;
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
    }

    public TaxiServiceDTO(TaxiService taxiService) {
        this.id = taxiService.getId();
        this.pib = taxiService.getPib();
        this.name = taxiService.getName();
        this.address = taxiService.getAddress();
        this.phoneNumber = taxiService.getPhoneNumber();
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
}
