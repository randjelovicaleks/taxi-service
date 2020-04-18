package com.taxiservice.controller;

import com.taxiservice.model.Customer;
import com.taxiservice.model.Dispatcher;
import com.taxiservice.model.Driver;
import com.taxiservice.security.authority.CustomUserDetailsService;
import com.taxiservice.security.authority.JwtAuthenticationDTO;
import com.taxiservice.security.authority.TokenState;
import com.taxiservice.security.utils.TokenUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping(value = "/auth/login")
public class LoginController {

    @Autowired
    private TokenUtils tokenUtils;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private CustomUserDetailsService userDetailsService;

    @PostMapping(consumes = "application/json")
    public ResponseEntity<?> login(@RequestBody JwtAuthenticationDTO authenticationDTO,
                                   HttpServletResponse response) throws AuthenticationException {
        final Authentication authentication = authenticationManager
                .authenticate(new UsernamePasswordAuthenticationToken(authenticationDTO.getUsername(),
                        authenticationDTO.getPassword()));

        SecurityContextHolder.getContext().setAuthentication(authentication);
        Object someUser = authentication.getPrincipal();

        if (someUser instanceof Customer) {
            Customer customer = (Customer) someUser;

            String jwt = tokenUtils.generateToken(customer.getUsername());
            int expiresIn = tokenUtils.getExpiredIn();
            return ResponseEntity.ok(new TokenState(jwt, expiresIn, customer.getId(), customer.getAuthority()));

        } else if (someUser instanceof Driver) {
            Driver driver = (Driver) someUser;

            String jwt = tokenUtils.generateToken(driver.getUsername());
            int expiresIn = tokenUtils.getExpiredIn();
            return ResponseEntity.ok(new TokenState(jwt, expiresIn, driver.getId(), driver.getAuthority()));

        } else if (someUser instanceof Dispatcher) {
            Dispatcher dispatcher = (Dispatcher) someUser;

            String jwt = tokenUtils.generateToken(dispatcher.getUsername());
            int expiresIn = tokenUtils.getExpiredIn();
            return ResponseEntity.ok(new TokenState(jwt, expiresIn, dispatcher.getId(), dispatcher.getAuthority()));

        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}
