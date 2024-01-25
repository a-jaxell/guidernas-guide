package org.guidernas.guideapi.activity;

import org.guidernas.guideapi.exception.ActivityNotFoundException;
import org.guidernas.guideapi.exception.ResourceNotFoundException;
import org.guidernas.guideapi.util.TestUtil;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ActivityControllerTest {

    @Mock
    private ActivityService activityService;

    @InjectMocks
    private ActivityController activityController;
    private Activity activity;
    private ActivityCreateDto activityCreateDto;
    private ActivityUpdateDto activityUpdateDto;
    @BeforeEach
    void setUp() {
        activity = new Activity();
        activityCreateDto = TestUtil.createActivityCreateDto("Active", "Sample Activity", LocalDateTime.now(), LocalDateTime.now().plusHours(2), ActivityType.HIKING);
        activityUpdateDto = TestUtil.createActivityUpdateDto(1L, "Updated Status", "Updated Description", LocalDateTime.now(), LocalDateTime.now().plusHours(2), ActivityType.SKIING);
    }


    @Test
    void getActivityByIdTest() {
        Long id = 1L;
        when(activityService.getActivityById(id)).thenReturn(activity);

        ResponseEntity<Activity> response = activityController.getActivityById(id);

        assertNotNull(response);
        assertEquals(response.getBody(), activity);
        verify(activityService).getActivityById(id);
    }
    @Test
    void getAllActivitiesTest() {
        List<Activity> activities = Arrays.asList(activity);
        when(activityService.getAllActivities()).thenReturn(activities);

        ResponseEntity<List<Activity>> response = activityController.getAllActivities();

        assertNotNull(response);
        assertEquals(response.getBody().size(), 1);
        verify(activityService).getAllActivities();
    }

    @Test
    void getAllActivitiesByGuideIdTest() {
        Long guideId = 1L;
        List<Activity> activities = Arrays.asList(activity);
        when(activityService.getAllActivitiesByGuideId(guideId)).thenReturn(activities);

        ResponseEntity<List<Activity>> response = activityController.getAllActivitiesByGuideId(guideId);

        assertNotNull(response);
        assertEquals(response.getBody().size(), 1);
        verify(activityService).getAllActivitiesByGuideId(guideId);
    }

    @Test
    void getAllActivitiesByOrganizationIdTest() {
        Long organizationId = 1L;
        List<Activity> activities = Arrays.asList(activity);
        when(activityService.getAllActivitiesByOrganizationId(organizationId)).thenReturn(activities);

        ResponseEntity<List<Activity>> response = activityController.getAllActivitiesByOrganizationId(organizationId);

        assertNotNull(response);
        assertEquals(response.getBody().size(), 1);
        verify(activityService).getAllActivitiesByOrganizationId(organizationId);
    }

    @Test
    void createActivityTest() {
        when(activityService.createActivity(activityCreateDto)).thenReturn(activity);

        ResponseEntity<Activity> response = activityController.createActivity(activityCreateDto);

        assertNotNull(response);
        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertEquals(activity, response.getBody());
        verify(activityService).createActivity(activityCreateDto);
    }
    @Test
    void updateActivityTest_success() {
        when(activityService.updateActivity(activityUpdateDto)).thenReturn(activity);

        ResponseEntity<Activity> response = activityController.updateActivity(activityUpdateDto);

        assertNotNull(response);
        assertEquals(HttpStatus.ACCEPTED, response.getStatusCode());
        assertEquals(activity, response.getBody());
        verify(activityService).updateActivity(activityUpdateDto);
    }
    @Test
    void deleteActivitySuccessTest() {
        Long id = 1L;
        when(activityService.deleteActivity(id)).thenReturn(true);

        ResponseEntity<Void> response = activityController.deleteActivity(id);

        assertNotNull(response);
        assertEquals(HttpStatus.NO_CONTENT, response.getStatusCode());
        verify(activityService).deleteActivity(id);
    }
    @Test
    void deleteActivityFailureTest() {
        Long id = 1L;
        when(activityService.deleteActivity(id)).thenReturn(false);

        ResponseEntity<Void> response = activityController.deleteActivity(id);

        assertNotNull(response);
        assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
        verify(activityService).deleteActivity(id);
    }
}