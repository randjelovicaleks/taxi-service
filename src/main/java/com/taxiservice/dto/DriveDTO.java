package com.taxiservice.dto;
import com.taxiservice.model.Drive;
import com.taxiservice.model.Driver;

import java.util.Date;

public class DriveDTO {

    private Long id;
    private Date orderDate;
    private String startingAddress;
    private DriverDTO driverDTO;
    private CustomerDTO customerDTO;
    private DispatcherDTO dispatcherDTO;
    private String note;
    private String customerName;

    public DriveDTO() {
    }

    public DriveDTO(Long id, Date orderDate, String startingAddress, DriverDTO driverDTO, CustomerDTO customerDTO,
                    DispatcherDTO dispatcherDTO, String note, String customerName) {
        this.id = id;
        this.orderDate = orderDate;
        this.startingAddress = startingAddress;
        this.driverDTO = driverDTO;
        this.customerDTO = customerDTO;
        this.dispatcherDTO = dispatcherDTO;
        this.note = note;
        this.customerName = customerName;
    }

    public DriveDTO(Drive drive) {
        this.id = drive.getId();
        this.orderDate = drive.getOrderDate();
        this.startingAddress = drive.getStartingAddress();
        if (drive.getDriver() != null) {
            this.driverDTO = new DriverDTO(drive.getDriver());
        }
        if (drive.getCustomer() != null) {
            this.customerDTO = new CustomerDTO(drive.getCustomer());
        }
        if (drive.getDispatcher() != null) {
            this.dispatcherDTO = new DispatcherDTO(drive.getDispatcher());
        }
        this.note = drive.getNote();
        this.customerName = drive.getCustomerName();
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

    public DriverDTO getDriverDTO() {
        return driverDTO;
    }

    public void setDriverDTO(DriverDTO driverDTO) {
        this.driverDTO = driverDTO;
    }

    public CustomerDTO getCustomerDTO() {
        return customerDTO;
    }

    public void setCustomerDTO(CustomerDTO customerDTO) {
        this.customerDTO = customerDTO;
    }

    public DispatcherDTO getDispatcherDTO() {
        return dispatcherDTO;
    }

    public void setDispatcherDTO(DispatcherDTO dispatcherDTO) {
        this.dispatcherDTO = dispatcherDTO;
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
}
