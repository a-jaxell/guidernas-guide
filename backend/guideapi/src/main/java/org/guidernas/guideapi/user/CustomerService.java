package org.guidernas.guideapi.user;

import org.guidernas.guideapi.exception.CustomerNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {

    private final CustomerRepository repository;

    public CustomerService(CustomerRepository repository) {
        this.repository = repository;
    }

    public Customer getCustomerById(Long id){
        return repository.findById(id).orElseThrow(CustomerNotFoundException::new);
    }
}
