package org.guidernas.guideapi.user.customer;

import org.guidernas.guideapi.activity.Activity;
import org.guidernas.guideapi.qualification.Qualification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/api/customers")
public class CustomerController {

    private final CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    // Get all customers
    @GetMapping
    public ResponseEntity<List<Customer>> getAllCustomers() {
        return ResponseEntity.ok(customerService.getAllCustomers());
    }

    // Get a customer by ID
    @GetMapping("/{id}")
    public ResponseEntity<Customer> getCustomerById(@PathVariable Long id) {
        return ResponseEntity.ok(customerService.getCustomerById(id));
    }

    // Get qualifications for a customer
    @GetMapping("/{customerId}/qualifications")
    public ResponseEntity<List<Qualification>> getCustomerQualifications(@PathVariable Long customerId) {
        return ResponseEntity.ok(customerService.getCustomerQualifications(customerId));
    }

    // Get activities for a customer
    @GetMapping("/{customerId}/activities")
    public ResponseEntity<Set<Activity>> getCustomerActivities(@PathVariable Long customerId) {
        return ResponseEntity.ok(customerService.getCustomerActivities(customerId));
    }

    // Create a new customer
    @PostMapping
    public ResponseEntity<Customer> createCustomer(@RequestBody CustomerCreateDto createDto) {
        return ResponseEntity.ok(customerService.createCustomer(createDto));
    }

    // Update a customer
    @PutMapping("/{id}")
    public ResponseEntity<Customer> updateCustomer(@PathVariable Long id, @RequestBody CustomerUpdateDto updateDto) {
        return ResponseEntity.ok(customerService.updateCustomer(id, updateDto));
    }

    // Delete a customer
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteCustomer(@PathVariable Long id) {
        boolean isDeleted = customerService.deleteCustomer(id);
        if (isDeleted) {
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
