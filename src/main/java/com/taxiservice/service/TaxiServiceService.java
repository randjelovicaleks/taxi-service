package com.taxiservice.service;

import com.taxiservice.dto.TaxiServiceDTO;
import com.taxiservice.model.TaxiService;

public interface TaxiServiceService {

    TaxiService getTaxiService(Long id);
    TaxiService updateTaxiService(TaxiServiceDTO taxiServiceDTO);
}
