package org.guidernas.guideapi.user.organization;

import jakarta.transaction.Transactional;
import org.guidernas.guideapi.exception.OrganizationNotFoundException;
import org.guidernas.guideapi.exception.ResourceNotFoundException;
import org.guidernas.guideapi.user.guide.Guide;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Set;

@Service
public class OrganizationService {

    private final OrganizationRepository organizationRepository;

    public OrganizationService(OrganizationRepository organizationRepository) {
        this.organizationRepository = organizationRepository;
    }
    public List<Organization> getAllOrganizations(){
        return organizationRepository.findAll();
    }
    public Organization getOrganizationById(Long id){
        return organizationRepository.findById(id).orElseThrow(OrganizationNotFoundException::new);
    }
    public Set<Guide> getGuidesByOrganization(Long organizationId){
        return organizationRepository.findById(organizationId)
                .map(Organization::getGuides)
                .orElse(Collections.emptySet());
    }
    @Transactional
    // Make custom validation for this method
    public Organization createOrganization(OrganizationCreateDto createDto){

        Organization newOrganization = new Organization();

        newOrganization.setDescription(createDto.description());
        newOrganization.setOrganizationName(createDto.organizationName());

        Organization savedOrganization = organizationRepository.save(newOrganization);
        return savedOrganization;
    }
    @Transactional
    public Organization updateOrganization(OrganizationUpdateDto updateDto) throws ResourceNotFoundException {
        Organization org = organizationRepository.findById(updateDto.id()).orElseThrow(OrganizationNotFoundException::new);

        if (updateDto.description() != null) org.setDescription(updateDto.description());
        if (updateDto.organizationName() != null) org.setOrganizationName(updateDto.organizationName());

        Organization updatedOrganization = organizationRepository.save(org);

        return updatedOrganization;
    }
    @Transactional
    public boolean deleteCustomer(Long orgId){
        var org = organizationRepository.findById(orgId);

        if(org.isPresent()){
            organizationRepository.deleteById(orgId);
            return true;
        }
        return false;
    }

}

