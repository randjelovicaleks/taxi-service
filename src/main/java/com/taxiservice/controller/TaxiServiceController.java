package com.taxiservice.controller;

import com.taxiservice.dto.TaxiServiceDTO;
import com.taxiservice.model.TaxiService;
import com.taxiservice.service.impl.TaxiServiceServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping(value = "/api/taxiservice")
public class TaxiServiceController {

    @Autowired
    private TaxiServiceServiceImpl taxiServiceService;

    @GetMapping(value = "/{id}")
    public ResponseEntity<TaxiServiceDTO> getTaxiService(@PathVariable Long id) {
        TaxiService taxiService = taxiServiceService.getTaxiService(id);

        if (taxiService != null) {
            return new ResponseEntity<>(new TaxiServiceDTO(taxiService), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @PutMapping(value = "/update", produces = "application/json", consumes = "application/json")
    public ResponseEntity<TaxiServiceDTO> updateTaxiService(@RequestBody TaxiServiceDTO taxiServiceDTO) {
        TaxiService taxiService = taxiServiceService.updateTaxiService(taxiServiceDTO);

        if (taxiService != null) {
            return new ResponseEntity<>(new TaxiServiceDTO(taxiService), HttpStatus.ACCEPTED);
        }

        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
}
