package org.guidernas.guideapi.activity;

import jakarta.transaction.Transactional;
import org.guidernas.guideapi.exception.ActivityNotFoundException;
import org.guidernas.guideapi.exception.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ActivityService {

    private final ActivityRepository repository;

    public ActivityService(ActivityRepository activityRepository) {
        this.repository = activityRepository;
    }

    public Activity getActivityById(Long id) {
        return repository.findById(id).orElseThrow(ActivityNotFoundException::new);
    }

    public List<Activity> getAllActivities() {
        return repository.findAll();
    }

    public List<Activity> getAllActivitiesByGuideId(Long guideId) {
        return repository.findActivitiesByGuideId(guideId);
    }

    public List<Activity> getAllActivitiesByOrganizationId(Long orgId) {
        return repository.findByHostOrganizationId(orgId);
    }

    @Transactional
    // Make custom validation for this method
    public Activity createActivity(ActivityCreateDto activityCreate) {

        Activity newActivity = new Activity();

        newActivity.setDescription(activityCreate.description());
        newActivity.setType(activityCreate.type());
        newActivity.setStatus(activityCreate.status());
        newActivity.setStartTime(activityCreate.startTime());
        newActivity.setEndTime(activityCreate.endTime());

        Activity savedActivity = repository.save(newActivity);
        return savedActivity;
    }

    @Transactional
    public Activity updateActivity(ActivityUpdateDto updateDto) throws ResourceNotFoundException {
        Activity activity = repository.findById(updateDto.id()).orElseThrow(ActivityNotFoundException::new);

        if (updateDto.status() != null) activity.setStatus(updateDto.status());
        if (updateDto.description() != null) activity.setStatus(updateDto.description());
        if (updateDto.startTime() != null) activity.setStartTime(updateDto.startTime());
        if (updateDto.endTime() != null) activity.setEndTime(updateDto.endTime());
        if (updateDto.type() != null) activity.setType(updateDto.type());

        Activity updatedActivity = repository.save(activity);

        return updatedActivity;
    }

    @Transactional
    public boolean deleteActivity(Long activityId) {
        var activity = repository.findById(activityId);

        if (activity.isPresent()) {
            repository.deleteById(activityId);
            return true;
        }
        return false;
    }


}
