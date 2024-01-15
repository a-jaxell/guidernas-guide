package org.guidernas.guideapi.exception;

public class OrganizationNotFoundException extends ResourceNotFoundException{

    public OrganizationNotFoundException(){super("Organization not found");}
}
