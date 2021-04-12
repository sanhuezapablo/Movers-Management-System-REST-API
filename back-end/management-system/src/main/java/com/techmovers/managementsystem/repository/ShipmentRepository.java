package com.techmovers.managementsystem.repository;

import com.techmovers.managementsystem.entities.Shipment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ShipmentRepository extends JpaRepository<Shipment, Long> {
    List<Shipment> findByCustomerFileId(Long customerId);
    Shipment findByIdAndCustomerFileId(Long customerId, Long shipmentId);
    Shipment findByRegistrationNumberAllIgnoreCase(String registrationNumber);
}
