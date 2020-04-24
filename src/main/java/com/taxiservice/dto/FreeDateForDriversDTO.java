package com.taxiservice.dto;

import java.util.Date;

public class FreeDateForDriversDTO {

    private Date freeDate;

    public FreeDateForDriversDTO() {
    }

    public FreeDateForDriversDTO(Date freeDate) {
        this.freeDate = freeDate;
    }

    public Date getFreeDate() {
        return freeDate;
    }

    public void setFreeDate(Date freeDate) {
        this.freeDate = freeDate;
    }
}
