package org.guidernas.guideapi.user.guide;

import jakarta.transaction.Transactional;
import org.guidernas.guideapi.exception.GuideNotFoundException;
import org.guidernas.guideapi.exception.ResourceNotFoundException;
import org.guidernas.guideapi.qualification.Qualification;
import org.guidernas.guideapi.qualification.QualificationRepository;
import org.guidernas.guideapi.user.organization.Organization;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Set;

@Service
public class GuideService {

    private final GuideRepository guideRepository;
    private final QualificationRepository qualificationRepository;

    public GuideService(GuideRepository guideRepository, QualificationRepository qualificationRepository) {
        this.guideRepository = guideRepository;
        this.qualificationRepository = qualificationRepository;
    }
    public List<Guide> getAll(){
        return guideRepository.findAll();
    }
    public Guide getGuideById(Long id){
        return guideRepository.findById(id).orElseThrow(GuideNotFoundException::new);
    }
    public List<Qualification> getGuideQualificationsById(Long guideId){
        return qualificationRepository.findByUserId(guideId);
    }
    public Set<Organization> getGuideOrganizations(Long guideId){
       return guideRepository.findByIdWithOrganizations(guideId)
                .map(Guide::getAssociatedOrganizations)
                .orElse(Collections.emptySet());
    }
    @Transactional
    // Make custom validation for this method
    public Guide createGuide(GuideCreateDto createDto){

        Guide newGuide = new Guide();

        newGuide.setFirstName(createDto.firstName());
        newGuide.setLastName(createDto.lastName());

        Guide savedGuide = guideRepository.save(newGuide);
        return savedGuide;
    }
    @Transactional
    public Guide updateGuide(Long id, GuideUpdateDto updateDto) throws ResourceNotFoundException {
        Guide guide = guideRepository.findById(id).orElseThrow(GuideNotFoundException::new);

        if (updateDto.firstName() != null) guide.setFirstName(updateDto.firstName());
        if (updateDto.lastName() != null) guide.setLastName(updateDto.lastName());

        Guide updatedGuide = guideRepository.save(guide);

        return updatedGuide;
    }
    @Transactional
    public boolean deleteCustomer(Long guideId){
        var guide = guideRepository.findById(guideId);

        if(guide.isPresent()){
            guideRepository.deleteById(guideId);
            return true;
        }
        return false;
    }
}
