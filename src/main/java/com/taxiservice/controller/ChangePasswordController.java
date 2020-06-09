package com.taxiservice.controller;

import com.taxiservice.dto.ChangePasswordDTO;
import com.taxiservice.security.authority.CustomUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping(value = "/api/user")
public class ChangePasswordController {

    @Autowired
    private CustomUserDetailsService customUserDetailsService;

    @PreAuthorize("hasRole('ROLE_CUSTOMER') or hasRole('ROLE_DRIVER') or hasRole('ROLE_DISPATCHER')")
    @PostMapping(value = "/password", consumes = "application/json")
    public ResponseEntity<?> changePassword(@RequestBody ChangePasswordDTO changePasswordDTO) {
        customUserDetailsService.changePassword(changePasswordDTO.getOldPassword(), changePasswordDTO.getNewPassword());
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
