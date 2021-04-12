package com.techmovers.managementsystem.repository;

import com.techmovers.managementsystem.entities.CompanyDivision;
import com.techmovers.managementsystem.entities.CustomerFile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CustomerFileRepository extends JpaRepository<CustomerFile, Long> {
    List<CustomerFile> findByCompanyDivisionId(Long id);
    CustomerFile findByIdAndCompanyDivisionId(Long customerId, Long companyId);
    List<CustomerFile> findByFirstNameAllIgnoreCase(String name);
    List<CustomerFile> findByFirstNameAndLastNameAllIgnoreCase(String firstName, String lastName);
}
