package com.taxiservice.model;

import com.taxiservice.dto.TaxiServiceDTO;
import com.taxiservice.dto.VehicleDTO;

import javax.persistence.*;

@Entity
public class Vehicle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "model", nullable = false)
    private String model;

    @Column(name = "manufacturer", nullable = false)
    private String manufacturer;

    @Column(name = "firstRegistration")
    private String firstRegistration;

    @Column(name = "registrationNumber", nullable = false)
    private String registrationNumber;

    @Column(name = "vehicleNumber", nullable = false)
    private String vehicleNumber;

    @ManyToOne(cascade = { CascadeType.MERGE, CascadeType.PERSIST }, fetch = FetchType.EAGER)
    private TaxiService taxiService;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "driver_id", referencedColumnName = "id")
    private Driver driver;

    public Vehicle() {
    }

    public Vehicle(Long id, String model, String manufacturer, String firstRegistration, String registrationNumber,
                   String vehicleNumber, TaxiService taxiService) {
        this.id = id;
        this.model = model;
        this.manufacturer = manufacturer;
        this.firstRegistration = firstRegistration;
        this.registrationNumber = registrationNumber;
        this.vehicleNumber = vehicleNumber;
        this.taxiService = taxiService;
    }

    public Vehicle(VehicleDTO vehicleDTO) {
        this.id = vehicleDTO.getId();
        this.model = vehicleDTO.getModel();
        this.manufacturer = vehicleDTO.getManufacturer();
        this.firstRegistration = vehicleDTO.getFirstRegistration();
        this.registrationNumber = vehicleDTO.getRegistrationNumber();
        this.vehicleNumber = vehicleDTO.getVehicleNumber();
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

    public Driver getDriver() {
        return driver;
    }

    public void setDriver(Driver driver) {
        this.driver = driver;
    }
}
