package com.techmovers.managementsystem.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import java.time.LocalDateTime;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class Shipment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonBackReference
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "customer_file_id")
    private CustomerFile customerFile;

    @Column(name = "Job_Status")
    private String status;

    @Column(name = "Registration_Number")
    private String registrationNumber;

    @Column(name = "Start_Date")
    private LocalDate startDate;

    @Column(name = "End_Date")
    private LocalDate endDate;

    //Make a class in the future. User should add these depending on their needs
    @Column(name = "Job_Type")
    private String jobType;

    @Column(name = "mode")
    private String mode;

    //Make a class in future. User should add these depending on their needs
    private String service;

    //Make a class in future
    private String packMode;
    private String routing;

    @JsonManagedReference
    @OneToOne(mappedBy = "shipment")
    private LocationAddress originAddress;

    @Column(name = "Updated_By")
    private String updatedBy;

    @Column(name = "Updated_Date_Time")
    private LocalDateTime updatedDateTime;


    public Shipment() {}

    public Shipment(Long id, String status, String registrationNumber, LocalDate startDate, LocalDate endDate,
                    String jobType, String mode, String service, String packMode, String routing, String updatedBy, LocalDateTime updatedDateTime) {
        this.id = id;
        this.status = status;
        this.registrationNumber = registrationNumber;
        this.startDate = startDate;
        this.endDate = endDate;
        this.jobType = jobType;
        this.mode = mode;
        this.service = service;
        this.packMode = packMode;
        this.routing = routing;
        this.updatedBy = updatedBy;
        this.updatedDateTime = updatedDateTime;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public CustomerFile getCustomerFile() {
        return customerFile;
    }

    public void setCustomerFile(CustomerFile customerFile) {
        this.customerFile = customerFile;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public void setRegistrationNumber(String registrationNumber) {
        this.registrationNumber = registrationNumber;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public String getJobType() {
        return jobType;
    }

    public void setJobType(String jobType) {
        this.jobType = jobType;
    }

    public String getMode() {
        return mode;
    }

    public void setMode(String mode) {
        this.mode = mode;
    }

    public String getService() {
        return service;
    }

    public void setService(String service) {
        this.service = service;
    }

    public String getPackMode() {
        return packMode;
    }

    public void setPackMode(String packMode) {
        this.packMode = packMode;
    }

    public String getRouting() {
        return routing;
    }

    public void setRouting(String routing) {
        this.routing = routing;
    }

    public LocationAddress getOriginAddress() {
        return originAddress;
    }

    public void setOriginAddress(LocationAddress originAddress) {
        this.originAddress = originAddress;
    }

    public String getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(String updatedBy) {
        this.updatedBy = updatedBy;
    }

    public LocalDateTime getUpdatedDateTime() {
        return updatedDateTime;
    }

    public void setUpdatedDateTime(LocalDateTime updatedDateTime) {
        this.updatedDateTime = updatedDateTime;
    }
}
