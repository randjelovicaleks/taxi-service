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

    public void changePassword(String oldPassword, String newPassword) {

        Authentication currentUser = SecurityContextHolder.getContext().getAuthentication();
        String username = currentUser.getName();

        if (authenticationManager != null) {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, oldPassword));

        } else {
            return;
        }

        Object object = loadUserByUsername(username);

        if (object instanceof Customer) {
            Customer customer = (Customer) object;
            // pre nego sto u bazu upisemo novu lozinku, potrebno ju je hesirati
            // ne zelimo da u bazi cuvamo lozinke u plain text formatu
            customer.setPassword(passwordEncoder.encode(newPassword));
            customerRepository.save(customer);
        } else if (object instanceof Driver) {
            Driver driver = (Driver) object;
            driver.setPassword(passwordEncoder.encode(newPassword));
            driverRepository.save(driver);
        } else if (object instanceof Dispatcher) {
            Dispatcher dispatcher = (Dispatcher) object;
            dispatcher.setPassword(passwordEncoder.encode(newPassword));
            dispatcherRepository.save(dispatcher);
        } else {
            System.out.println("User with username " + username + " can not change password.");
        }





    }
}
