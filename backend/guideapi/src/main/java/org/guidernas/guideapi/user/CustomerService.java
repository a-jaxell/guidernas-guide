package org.guidernas.guideapi.user;

import org.guidernas.guideapi.activity.Activity;
import org.guidernas.guideapi.exception.CustomerNotFoundException;
import org.guidernas.guideapi.qualification.Qualification;
import org.guidernas.guideapi.qualification.QualificationRepository;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Set;

@Service
public class CustomerService {

    // TODO: Implement a service method for finding all customers by certification type.
    private final CustomerRepository customerRepository;
    private final QualificationRepository qualificationRepository;

    public CustomerService(CustomerRepository customerRepository, QualificationRepository qualificationRepository) {
        this.customerRepository = customerRepository;
        this.qualificationRepository = qualificationRepository;
    }

    public List<Customer> getAllCustomers(){
        return customerRepository.findAll();
    }
    public Customer getCustomerById(Long id){
        return customerRepository.findById(id).orElseThrow(CustomerNotFoundException::new);
    }
    public List<Qualification> getCustomerQualifications(Long customerId){
        return qualificationRepository.findByUserId(customerId);
    }
    public Set<Activity> getCustomerActivities(Long customerId){
        return customerRepository.findByIdWithAttendedActivities(customerId)
                .map(Customer::getAttendedActivities)
                .orElse(Collections.emptySet());
    }
    // TODO: Add CRUD methods

}
