package org.guidernas.guideapi.activity;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/activities")
public class ActivityController {

    private final ActivityService activityService;

    public ActivityController(ActivityService activityService) {
        this.activityService = activityService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Activity> getActivityById(@PathVariable Long id) {
        return ResponseEntity.ok(activityService.getActivityById(id));
    }

    @GetMapping
    public ResponseEntity<List<Activity>> getAllActivities() {
        return ResponseEntity.ok(activityService.getAllActivities());
    }

    @GetMapping("/guide/{guideId}")
    public ResponseEntity<List<Activity>> getAllActivitiesByGuideId(@PathVariable Long guideId) {
        return ResponseEntity.ok(activityService.getAllActivitiesByGuideId(guideId));
    }

    @GetMapping("/organization/{orgId}")
    public ResponseEntity<List<Activity>> getAllActivitiesByOrganizationId(@PathVariable Long orgId) {
        return ResponseEntity.ok(activityService.getAllActivitiesByOrganizationId(orgId));
    }

    @PostMapping
    public ResponseEntity<Activity> createActivity(@RequestBody ActivityCreateDto activityCreate) {
        return ResponseEntity.status(HttpStatus.CREATED).body(activityService.createActivity(activityCreate));
    }

    @PutMapping
    public ResponseEntity<Activity> updateActivity(@RequestBody ActivityUpdateDto updateDto) {
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(activityService.updateActivity(updateDto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteActivity(@PathVariable Long id) {
        if(activityService.deleteActivity(id)){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.badRequest().build();
    }
}
