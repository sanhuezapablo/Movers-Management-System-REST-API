package com.techmovers.managementsystem.repository;

import com.techmovers.managementsystem.entities.CompanyDivision;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompanyDivisionRepository extends JpaRepository<CompanyDivision, Long> {

}
