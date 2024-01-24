package org.guidernas.guideapi.activity;

import org.guidernas.guideapi.exception.ActivityNotFoundException;
import org.guidernas.guideapi.exception.ResourceNotFoundException;
import org.guidernas.guideapi.util.TestUtil;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ActivityServiceTest {

    @Mock
    private ActivityRepository repository;

    @InjectMocks
    private ActivityService service;



    @Test
    void getActivityById_validId_returnsActivity() {
        Long validId = 1L;
        Activity mockActivity = new Activity();
        when(repository.findById(validId)).thenReturn(Optional.of(mockActivity));

        Activity result = service.getActivityById(validId);

        assertEquals(mockActivity, result);
    }
    @Test
    void getActivityById_invalidId_throwsException() {
        Long invalidId = 2L;
        when(repository.findById(invalidId)).thenReturn(Optional.empty());

        assertThrows(ActivityNotFoundException.class, () -> {
            service.getActivityById(invalidId);
        });
    }
    @Test
    void whenGetAllActivities_thenAllActivitiesShouldBeReturned() {
        List<Activity> activities = List.of(new Activity(), new Activity());
        when(repository.findAll()).thenReturn(activities);

        List<Activity> result = service.getAllActivities();

        assertEquals(activities, result);
    }

    @Test
    void getAllActivitiesByGuideId_validId_returnsActivities() {
        Long validId = 1L;
        List<Activity> activities = List.of(new Activity(), new Activity());
        when(repository.findActivitiesByGuideId(validId)).thenReturn(activities);

        List<Activity> result = service.getAllActivitiesByGuideId(validId);

        assertEquals(activities, result);
    }
    @Test
    void getAllActivitiesByGuideId_invalidId_throwsException() {
        Long invalidId = 2L;
        when(repository.findActivitiesByGuideId(invalidId)).thenThrow(ResourceNotFoundException.class);

        assertThrows(ResourceNotFoundException.class, () -> {
            service.getAllActivitiesByGuideId(invalidId);
        });
    }
    @Test
    void getAllActivitiesByOrganizationId_validId_returnsActivities() {
        Long validId = 1L;
        List<Activity> activities = List.of(new Activity(), new Activity());
        when(repository.findByHostOrganizationId(validId)).thenReturn(activities);

        List<Activity> result = service.getAllActivitiesByOrganizationId(validId);

        assertEquals(activities, result);
    }
    @Test
    void getAllActivitiesByOrganizationId_invalidId_throwsException() {
        Long invalidId = 2L;
        when(repository.findByHostOrganizationId(invalidId)).thenThrow(ResourceNotFoundException.class);

        assertThrows(ResourceNotFoundException.class, () -> {
            service.getAllActivitiesByOrganizationId(invalidId);
        });
    }

    @Test
    void whenCreateActivity_thenActivityShouldBeSaved() {
        ActivityCreateDto dto = TestUtil.createActivityCreateDto("Active", "Sample Activity", LocalDateTime.now(), LocalDateTime.now().plusHours(2), ActivityType.HIKING);
        Activity savedActivity = new Activity();
        when(repository.save(any(Activity.class))).thenReturn(savedActivity);

        Activity result = service.createActivity(dto);

        assertEquals(savedActivity, result);
    }

    @Test
    public void whenUpdateActivity_thenActivityShouldBeUpdated() {
        ActivityUpdateDto updateDto = TestUtil.createActivityUpdateDto(1L, "Updated Status", "Updated Description", LocalDateTime.now(), LocalDateTime.now().plusHours(2), ActivityType.SKIING);
        Activity existingActivity = new Activity();
        when(repository.findById(updateDto.id())).thenReturn(Optional.of(existingActivity));
        when(repository.save(any(Activity.class))).thenReturn(existingActivity);

        Activity result = service.updateActivity(updateDto);

        assertEquals(existingActivity, result);
    }
    @Test
    public void whenUpdateActivityWithInvalidId_thenThrowActivityNotFoundException(){
        ActivityUpdateDto updateDto = TestUtil.createActivityUpdateDto(1L, "Updated Status", "Updated Description", LocalDateTime.now(), LocalDateTime.now().plusHours(2), ActivityType.SKIING);
        when(repository.findById(updateDto.id())).thenThrow(ActivityNotFoundException.class);

        assertThrows(ActivityNotFoundException.class, () ->
                service.updateActivity(updateDto));
    }

    @Test
    void whenDeleteActivity_thenActivityShouldBeDeleted() {
        Long valid = 1L;
        Activity existingActivity = new Activity();
        when(repository.findById(valid)).thenReturn(Optional.of(existingActivity));

        boolean result = service.deleteActivity(valid);

        assertTrue(result);
        verify(repository, times(1)).deleteById(valid);
    }
}