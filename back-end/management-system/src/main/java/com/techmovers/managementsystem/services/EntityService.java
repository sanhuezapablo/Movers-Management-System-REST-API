package com.techmovers.managementsystem.services;

import com.techmovers.managementsystem.controllers.EntityController;
import com.techmovers.managementsystem.entities.CompanyDivision;
import com.techmovers.managementsystem.entities.CustomerFile;
import com.techmovers.managementsystem.entities.LocationAddress;
import com.techmovers.managementsystem.entities.Shipment;
import com.techmovers.managementsystem.repository.CompanyDivisionRepository;
import com.techmovers.managementsystem.repository.CustomerFileRepository;
import com.techmovers.managementsystem.repository.LocationAddressRepository;
import com.techmovers.managementsystem.repository.ShipmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EntityService {

    @Autowired
    private CompanyDivisionRepository companyRepository;

    @Autowired
    private CustomerFileRepository customerRepository;

    @Autowired
    private ShipmentRepository shipmentRepository;

    @Autowired
    private LocationAddressRepository locationRepository;

    public EntityService(CompanyDivisionRepository companyRepository, CustomerFileRepository customerRepository,
                         ShipmentRepository shipmentRepository, LocationAddressRepository locationRepository) {
    }

    /**
     * Create
     */
    public CompanyDivision saveCompanyDivision(CompanyDivision companyDivision) {
        return companyRepository.save(companyDivision);
    }

    public CustomerFile saveCustomerFile(Long companyId, CustomerFile customerFile) {
        customerFile.setCompanyDivision(companyRepository.findById(companyId).get());

        return customerRepository.save(customerFile);
    }

    public Shipment saveShipment(Long customerId, Shipment shipment) {
        shipment.setCustomerFile(customerRepository.findById(customerId).get());
        return shipmentRepository.save(shipment);
    }

    public LocationAddress saveAddress(Long shipmentId, LocationAddress address) {
        address.setShipment(shipmentRepository.findById(shipmentId).get());
        return locationRepository.save(address);
    }

    /**
     * Read
     */
    public List<CompanyDivision> getCompanyDivisions() {
        return companyRepository.findAll();
    }

    public CompanyDivision getCompanyDivision(Long companyId) {
        return companyRepository.findById(companyId).get();
    }

    public List<CustomerFile> getAllCustomerFilesByCompany(Long companyId) {
        return customerRepository.findByCompanyDivisionId(companyId);
    }

    public List<CustomerFile> getAllCustomerFiles() {
        return customerRepository.findAll();
    }

    public CustomerFile getCustomerFile(Long customerId, Long companyId) {
        return customerRepository.findByIdAndCompanyDivisionId(customerId, companyId);
    }

    public List<Shipment> getAllShipmentsByCustomer(Long customerId) {
        return shipmentRepository.findByCustomerFileId(customerId);
    }

    public Shipment getShipmentByCustomerId(Long customerId, Long shipmentId) {
        return shipmentRepository.findByIdAndCustomerFileId(customerId, shipmentId);
    }

    public LocationAddress getOriginAddress(Long originId) {
        return locationRepository.findById(originId).get();
    }

    /**
     * Update
     */
    public CompanyDivision updateCompanyDivision(Long companyId, CompanyDivision companyDivision) {
        companyDivision.setId(companyId);
        return companyRepository.save(companyDivision);
    }

    public CustomerFile updateCustomerFile(Long customerId, CustomerFile customerFile) {
        customerFile.setId(customerId);
        return customerRepository.save(customerFile);
    }

    public Shipment updateShipment(Long shipmentId, Shipment shipment) {
        shipment.setId(shipmentId);
        return shipmentRepository.save(shipment);
    }

    public LocationAddress updateOriginAddress(Long addressId, LocationAddress locationAddress) {
        locationAddress.setId(addressId);
        return locationRepository.save(locationAddress);
    }

    /**
     * Delete
     */
    public void deleteCompanyDivision(Long companyId) {
        companyRepository.deleteById(companyId);
    }

    public void deleteCustomerFile(Long customerId) {
        customerRepository.deleteById(customerId);
    }

    public void deleteShipment(Long shipmentId) {
        shipmentRepository.deleteById(shipmentId);
    }

    public void deleteAddress(Long addressId) {
        locationRepository.deleteById(addressId);
    }
}
