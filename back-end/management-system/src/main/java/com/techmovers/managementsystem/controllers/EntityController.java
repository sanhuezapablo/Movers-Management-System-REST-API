package com.techmovers.managementsystem.controllers;

import com.techmovers.managementsystem.entities.CompanyDivision;
import com.techmovers.managementsystem.entities.CustomerFile;
import com.techmovers.managementsystem.entities.Shipment;
import com.techmovers.managementsystem.services.EntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.parameters.P;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@CrossOrigin
public class EntityController {

    @Autowired
    private EntityService entityService;

    public EntityController(EntityService entityService) {
    }

    /**
     * Company Division CRUD
     */
    @GetMapping(path = "/division")
    public List<CompanyDivision> getAllCompanyDivisions() {
        return entityService.getCompanyDivisions();
    }

    @GetMapping(path = "/division/{companyId}")
    public EntityModel<CompanyDivision> getCompanyDivision(@PathVariable Long companyId) {
        CompanyDivision companyDivision = entityService.getCompanyDivision(companyId);
        EntityModel<CompanyDivision> companyEntity = EntityModel.of(companyDivision);
        Link allCompanies = linkTo(methodOn(this.getClass()).getAllCompanyDivisions()).withRel("all-companies");
        Link deleteCompany = linkTo(methodOn(this.getClass()).deleteCompanyDivision(companyId)).withRel("delete-company");
        companyEntity.add(allCompanies, deleteCompany);

        return companyEntity;
    }

    @PostMapping(path = "/division")
    public EntityModel<CompanyDivision> createCompanyDivision(@RequestBody CompanyDivision companyDivision) {
        CompanyDivision newCompany = entityService.saveCompanyDivision(companyDivision);
        EntityModel<CompanyDivision> entityModel = EntityModel.of(newCompany);
        Link getCompany = linkTo(methodOn(this.getClass()).getCompanyDivision(newCompany.getId())).withRel("get-company");
        Link deleteCompany = linkTo(methodOn(this.getClass()).deleteCompanyDivision(newCompany.getId())).withRel("delete-company");
        entityModel.add(getCompany, deleteCompany);

        return entityModel;
    }

    @PutMapping(path = "/division/{companyId}")
    public EntityModel<CompanyDivision> updateCompanyDivision(@PathVariable Long companyId, @RequestBody CompanyDivision companyDivision) {
        CompanyDivision updatedCompany = entityService.updateCompanyDivision(companyId, companyDivision);
        EntityModel<CompanyDivision> entityModel = EntityModel.of(updatedCompany);
        Link getCompany = linkTo(methodOn(this.getClass()).getCompanyDivision(updatedCompany.getId())).withRel("get-company");
        Link deleteCompany = linkTo(methodOn(this.getClass()).deleteCompanyDivision(updatedCompany.getId())).withRel("delete-company");
        entityModel.add(getCompany, deleteCompany);

        return entityModel;
    }

    @DeleteMapping(path = "/division/{companyId}")
    public ResponseEntity<?> deleteCompanyDivision(@PathVariable Long companyId) {
        entityService.deleteCompanyDivision(companyId);

        return new ResponseEntity<String>("Company Division Deleted", HttpStatus.OK);
    }

    /**
     * Customer File CRUD
     */
    @GetMapping(path = "division/{companyId}/customer")
    public List<CustomerFile> getAllCustomerFilesByCompany(@PathVariable Long companyId) {
        return entityService.getAllCustomerFilesByCompany(companyId);
    }

    @GetMapping(path = "division/{companyId}/customer/{customerId}")
    public EntityModel<CustomerFile> getCustomerFile(@PathVariable Long companyId, @PathVariable Long customerId) {
        CustomerFile customerFile = entityService.getCustomerFile(customerId, companyId);
        EntityModel<CustomerFile> entityModel = EntityModel.of(customerFile);
        Link getAllCustomers = linkTo(methodOn(this.getClass()).getAllCustomerFilesByCompany(companyId)).withRel("get-all-customers");
        entityModel.add(getAllCustomers);
        return entityModel;
    }

    @PostMapping(path = "division/{companyId}/customer")
    public EntityModel<CustomerFile> createCustomerFile(@PathVariable Long companyId, @RequestBody CustomerFile customerFile) {
        CustomerFile newCustomer = entityService.saveCustomerFile(companyId, customerFile);
        EntityModel<CustomerFile> entityModel = EntityModel.of(newCustomer);
        Link getCustomer = linkTo(methodOn(this.getClass()).getCustomerFile(companyId, newCustomer.getId())).withRel("get-customer");
        Link allCustomers = linkTo(methodOn(this.getClass()).getAllCustomerFilesByCompany(companyId)).withRel("all-customers");

        return entityModel;
    }

    @PutMapping(path = "division/{companyId}/customer/{customerId}")
    public EntityModel<CustomerFile> updateCustomerFile(@PathVariable Long companyId, @PathVariable Long customerId, @RequestBody CustomerFile customerFile) {
        CustomerFile updatedCustomer = entityService.saveCustomerFile(customerId,customerFile);
        EntityModel<CustomerFile> entityModel = EntityModel.of(updatedCustomer);

        return entityModel;
    }

    @DeleteMapping(path = "division/{companyId}/customer/{customerId}")
    public ResponseEntity<?> deleteCustomerFile(@PathVariable Long companyId, @PathVariable Long customerId) {
        entityService.deleteCustomerFile(customerId);

        return new ResponseEntity<String>("Customer File Deleted", HttpStatus.OK);
    }

    /**
     * Shipment CRUD
     */
    @GetMapping(path = "division/{companyId}/customer/{customerId}/shipment")
    public List<Shipment> getShipmentsByCustomer(@PathVariable Long customerId) {
        return entityService.getAllShipmentsByCustomer(customerId);
    }

    @GetMapping(path = "division/{companyId}/customer/{customerId}/shipment/{shipmentId}")
    public EntityModel<Shipment> getShipment(@PathVariable Long customerId, @PathVariable Long shipmentId) {
        Shipment shipment = entityService.getShipmentByCustomerId(customerId, shipmentId);
        EntityModel<Shipment> entityModel = EntityModel.of(shipment);

        return entityModel;
    }

    @PostMapping(path = "division/{companyId}/customer/{customerId}/shipment")
    public EntityModel<Shipment> createShipment(@PathVariable Long customerId, @RequestBody Shipment shipment) {
        Shipment newShipment = entityService.saveShipment(customerId, shipment);
        EntityModel<Shipment> entityModel = EntityModel.of(newShipment);

        return entityModel;
    }

    @PutMapping(path = "division/{companyId}/customer/{customerId}/shipment/{shipmentId}")
    public EntityModel<Shipment> updateShipment(@PathVariable Long shipmentId, @RequestBody Shipment shipment) {
        Shipment updatedShipment = entityService.updateShipment(shipmentId, shipment);
        EntityModel<Shipment> entityModel = EntityModel.of(updatedShipment);

        return entityModel;
    }

    @DeleteMapping(path = "division/{companyId}/customer/{customerId}/shipment/{shipmentId}")
    public ResponseEntity<?> deleteShipment(@PathVariable Long shipmentId) {
        entityService.deleteShipment(shipmentId);

        return new ResponseEntity<String>("Shipment has been deleted", HttpStatus.OK);
    }

}
