package org.guidernas.guideapi.activity;

import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;

@Service
public class ActivityService {

    private final ActivityRepository repository;

    public ActivityService(ActivityRepository activityRepository){
        this.repository = activityRepository;
    }

    public Activity getActivityById(Long id){
        return repository.findById(id).orElseThrow(IllegalAccessError::new);
    }
    // create new activity
    // update activity
    // delete activity


}
