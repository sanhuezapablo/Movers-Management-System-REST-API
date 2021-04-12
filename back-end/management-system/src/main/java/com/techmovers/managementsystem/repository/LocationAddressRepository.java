package com.techmovers.managementsystem.repository;

import com.techmovers.managementsystem.entities.LocationAddress;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LocationAddressRepository extends JpaRepository<LocationAddress, Long> {

}
