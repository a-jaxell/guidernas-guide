package org.guidernas.guideapi.user.customer;

import jakarta.transaction.Transactional;
import org.guidernas.guideapi.activity.Activity;
import org.guidernas.guideapi.exception.CustomerNotFoundException;
import org.guidernas.guideapi.exception.ResourceNotFoundException;
import org.guidernas.guideapi.qualification.Qualification;
import org.guidernas.guideapi.qualification.QualificationRepository;
import org.springframework.stereotype.Service;

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
    @Transactional
    // Make custom validation for this method
    public Customer createCustomer(CustomerCreateDto createDto){

        Customer newCustomer = new Customer();

        newCustomer.setFirstName(createDto.firstName());
        newCustomer.setLastName(createDto.lastName());

        Customer savedCustomer = customerRepository.save(newCustomer);
        return savedCustomer;
    }
    @Transactional
    public Customer updateCustomer(Long id, CustomerUpdateDto updateDto) throws ResourceNotFoundException {
        Customer customer = customerRepository.findById(id).orElseThrow(CustomerNotFoundException::new);

        if (updateDto.firstName() != null) customer.setFirstName(updateDto.firstName());
        if (updateDto.lastName() != null) customer.setLastName(updateDto.lastName());

        Customer updatedCustomer = customerRepository.save(customer);

        return updatedCustomer;
    }
    @Transactional
    public boolean deleteCustomer(Long customerId){
        var customer = customerRepository.findById(customerId);

        if(customer.isPresent()){
            customerRepository.deleteById(customerId);
            return true;
        }
        return false;
    }
}
