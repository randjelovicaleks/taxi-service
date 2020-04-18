package com.taxiservice.security.authority;

import com.taxiservice.model.Customer;
import com.taxiservice.model.Dispatcher;
import com.taxiservice.model.Driver;
import com.taxiservice.repository.CustomerRepository;
import com.taxiservice.repository.DispatcherRepository;
import com.taxiservice.repository.DriverRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Lazy
    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private DriverRepository driverRepository;

    @Autowired
    private DispatcherRepository dispatcherRepository;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Customer customer = customerRepository.findByUsername(username);
        Driver driver = driverRepository.findByUsername(username);
        Dispatcher dispatcher = dispatcherRepository.findByUsername(username);

        if (customer != null) {
            return customer;
        } else if (driver != null) {
            return driver;
        } else if (dispatcher != null) {
            return dispatcher;
        } else {
            throw new UsernameNotFoundException(String.format("User with username: '%s' is not found.", username));
        }
    }

    //funkcija za izmenu lozinke
}
