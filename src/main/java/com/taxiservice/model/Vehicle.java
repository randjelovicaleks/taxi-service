package com.taxiservice.model;

public class Vehicle {

    private Long id;
    private String model;
    private String manufacturer;
    private String firstRegistration;
    private String registrationNumber;
    private String vehicleNumber;
    private TaxiService taxiService;

    public Vehicle() {
    }

    public Vehicle(Long id, String model, String manufacturer, String firstRegistration, String registrationNumber,
                   String vehicleNumber) {
        this.id = id;
        this.model = model;
        this.manufacturer = manufacturer;
        this.firstRegistration = firstRegistration;
        this.registrationNumber = registrationNumber;
        this.vehicleNumber = vehicleNumber;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getFirstRegistration() {
        return firstRegistration;
    }

    public void setFirstRegistration(String firstRegistration) {
        this.firstRegistration = firstRegistration;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public void setRegistrationNumber(String registrationNumber) {
        this.registrationNumber = registrationNumber;
    }

    public String getVehicleNumber() {
        return vehicleNumber;
    }

    public void setVehicleNumber(String vehicleNumber) {
        this.vehicleNumber = vehicleNumber;
    }

    public TaxiService getTaxiService() {
        return taxiService;
    }

    public void setTaxiService(TaxiService taxiService) {
        this.taxiService = taxiService;
    }
}
