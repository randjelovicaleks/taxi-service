package com.taxiservice.service.impl;

import com.taxiservice.dto.TaxiServiceDTO;
import com.taxiservice.model.TaxiService;
import com.taxiservice.repository.TaxiServiceRepository;
import com.taxiservice.service.TaxiServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TaxiServiceServiceImpl implements TaxiServiceService {

    @Autowired
    private TaxiServiceRepository taxiServiceRepository;

    @Override
    public TaxiService getTaxiService(Long id) {
        return taxiServiceRepository.getOne(id);
    }

    @Override
    public TaxiService updateTaxiService(TaxiServiceDTO taxiServiceDTO) {
        TaxiService taxiService = getTaxiService(taxiServiceDTO.getId());

        if (taxiService != null) {
            taxiService.setName(taxiServiceDTO.getName());
            taxiService.setAddress(taxiServiceDTO.getAddress());
            taxiService.setPhoneNumber(taxiServiceDTO.getPhoneNumber());
        }

        taxiServiceRepository.save(taxiService);
        return taxiService;
    }

}
