package org.guidernas.guideapi.activity;

import org.guidernas.guideapi.exception.ActivityNotFoundException;
import org.guidernas.guideapi.user.GuideRepository;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ActivityService {

    private final ActivityRepository repository;

    public ActivityService(ActivityRepository activityRepository){
        this.repository = activityRepository;
    }

    public Activity getActivityById(Long id){
        return repository.findById(id).orElseThrow(ActivityNotFoundException::new);
    }
    public List<Activity> getAllActivities(){
        return repository.findAll();
    }
    public List<Activity> getAllActivitiesByGuideId(Long guideId){
        return repository.findActivitiesByGuideId(guideId);
    }
    public List<Activity> getAllActivitiesByOrganizationId(Long orgId){
        return repository.findByHostOrganizationId(orgId);
    }
    // create new activity
    // update activity
    // delete activity


}
