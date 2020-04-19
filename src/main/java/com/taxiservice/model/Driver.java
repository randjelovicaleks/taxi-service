package com.taxiservice.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.taxiservice.dto.DriverDTO;
import com.taxiservice.security.authority.Authority;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Entity
public class Driver implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "username", nullable = false, unique = true)
    private String username;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "surname", nullable = false)
    private String surname;

    @Column(name = "address", nullable = false)
    private String address;

    @Column(name = "phoneNumber", nullable = false)
    private String phoneNumber;

    @Column(name = "salary", nullable = false)
    private double salary;

    @Column(name = "taxiCardNumber", nullable = false) //broj članske karte udruženja taksista
    private String taxiCardNumber;

    @ManyToOne(cascade = { CascadeType.MERGE, CascadeType.PERSIST }, fetch = FetchType.EAGER)
    private TaxiService taxiService;

    @OneToMany(mappedBy = "driver", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Drive> drives;

    @LazyCollection(LazyCollectionOption.FALSE)
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "driver_authority",
            joinColumns = @JoinColumn(name = "driver_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "authority_id", referencedColumnName = "id"))
    private List<Authority> authorities;

    public Driver() {
    }

    public Driver(Long id, String username, String password, String name, String surname, String address,
                  String phoneNumber, double salary, String taxiCardNumber, TaxiService taxiService) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.name = name;
        this.surname = surname;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.salary = salary;
        this.taxiCardNumber = taxiCardNumber;
        this.taxiService = taxiService;
        this.drives = new ArrayList<>();
    }

    public Driver(DriverDTO driverDTO) {
        this.id = driverDTO.getId();
        this.username = driverDTO.getUsername();
        this.password = driverDTO.getPassword();
        this.name = driverDTO.getName();
        this.surname = driverDTO.getSurname();
        this.address = driverDTO.getAddress();
        this.phoneNumber = driverDTO.getPhoneNumber();
        this.salary = driverDTO.getSalary();
        this.taxiCardNumber = driverDTO.getTaxiCardNumber();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    @JsonIgnore
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @JsonIgnore
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @JsonIgnore
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @JsonIgnore
    @Override
    public boolean isEnabled() {
        return true;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getTaxiCardNumber() {
        return taxiCardNumber;
    }

    public void setTaxiCardNumber(String taxiCardNumber) {
        this.taxiCardNumber = taxiCardNumber;
    }

    public TaxiService getTaxiService() {
        return taxiService;
    }

    public void setTaxiService(TaxiService taxiService) {
        this.taxiService = taxiService;
    }

    public List<Drive> getDrives() {
        return drives;
    }

    public void setDrives(List<Drive> drives) {
        this.drives = drives;
    }

    public void setAuthorities(List<Authority> authorities) {
        this.authorities = authorities;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return this.authorities;
    }

    public Authority getAuthority() {
        if(this.authorities.size() > 0)
            return this.authorities.get(0);
        else
            return null;
    }
}
