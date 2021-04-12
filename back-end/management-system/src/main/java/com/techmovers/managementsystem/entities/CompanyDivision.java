package com.techmovers.managementsystem.entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Table(name = "COMPANY_DIVISIONS")
public class CompanyDivision {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "COMPANY_ID")
    private Long id;

    private String name;
    private String updatedBy;
    private LocalDateTime updatedDateTime;

    @JsonManagedReference
    @OneToMany(mappedBy = "companyDivision", fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
    private Set<CustomerFile> customerFiles;

    public CompanyDivision() {

    }

    public CompanyDivision(String name, String updatedBy, LocalDateTime updatedDateTime) {
        this.name = name;
        this.updatedBy = updatedBy;
        this.updatedDateTime = updatedDateTime;
    }

    public Long getId() {

        return id;
    }

    public void setId(Long id) {

        this.id = id;
    }

    public String getName() {

        return name;
    }

    public void setName(String name) {

        this.name = name;
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

    public Set<CustomerFile> getCustomerFiles() {

        return customerFiles;
    }

    public void setCustomerFiles(Set<CustomerFile> customerFiles) {

        this.customerFiles = customerFiles;
    }
}
