package com.taxiservice.dto;
import com.taxiservice.model.Drive;

import java.util.Date;

public class DriveDTO {

    private Long id;
    private Date orderDate;
    private String startingAddress;
    private DriverDTO driverDTO;
    private CustomerDTO customerDTO;
    private DispatcherDTO dispatcherDTO;
    private String note;

    public DriveDTO() {
    }

    public DriveDTO(Long id, Date orderDate, String startingAddress, DriverDTO driverDTO, CustomerDTO customerDTO,
                    DispatcherDTO dispatcherDTO, String note) {
        this.id = id;
        this.orderDate = orderDate;
        this.startingAddress = startingAddress;
        this.driverDTO = driverDTO;
        this.customerDTO = customerDTO;
        this.dispatcherDTO = dispatcherDTO;
        this.note = note;
    }

    public DriveDTO(Drive drive) {
        this.id = drive.getId();
        this.orderDate = drive.getOrderDate();
        this.startingAddress = drive.getStartingAddress();
        this.driverDTO = new DriverDTO(drive.getDriver());
        this.customerDTO = new CustomerDTO(drive.getCustomer());
        this.dispatcherDTO = new DispatcherDTO(drive.getDispatcher());
        this.note = drive.getNote();
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
}
