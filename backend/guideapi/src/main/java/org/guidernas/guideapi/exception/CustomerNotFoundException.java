package org.guidernas.guideapi.exception;

public class CustomerNotFoundException extends ResourceNotFoundException{

    public CustomerNotFoundException(){
        super("Customer not found");
    }
}
