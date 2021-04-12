package com.techmovers.managementsystem.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import javax.xml.stream.Location;

@Entity
public class LocationAddress {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "Address_1")
    private String address1;

    @Column(name = "Address_2")
    private String address2;

    @Column(name = "Country")
    private String country;

    @Column(name = "State")
    private String state;

    @Column(name = "City")
    private String city;

    @Column(name = "Postal_Code")
    private Short postalCode;

    @JsonBackReference
    @OneToOne
    @JoinColumn(name = "shipment_id")
    private Shipment shipment;

    public LocationAddress() {

    }

    public LocationAddress(String address1, String address2, String country, String state, String city, Short postalCode) {
        this.address1 = address1;
        this.address2 = address2;
        this.country = country;
        this.state = state;
        this.city = city;
        this.postalCode = postalCode;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAddress1() {
        return address1;
    }

    public void setAddress1(String address1) {
        this.address1 = address1;
    }

    public String getAddress2() {
        return address2;
    }

    public void setAddress2(String address2) {
        this.address2 = address2;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Short getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(Short postalCode) {
        this.postalCode = postalCode;
    }

    public Shipment getShipment() {
        return shipment;
    }

    public void setShipment(Shipment shipment) {
        this.shipment = shipment;
    }
}