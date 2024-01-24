package org.guidernas.guideapi.util;

import org.guidernas.guideapi.activity.ActivityCreateDto;
import org.guidernas.guideapi.activity.ActivityType;
import org.guidernas.guideapi.activity.ActivityUpdateDto;

import java.time.LocalDateTime;

public class TestUtil {
    public static ActivityCreateDto createActivityCreateDto(String status, String description, LocalDateTime startTime, LocalDateTime endTime, ActivityType type) {
        return new ActivityCreateDto(status, description, startTime, endTime, type);
    }

    public static ActivityUpdateDto createActivityUpdateDto(Long id, String status, String description, LocalDateTime startTime, LocalDateTime endTime, ActivityType type) {
        return new ActivityUpdateDto(id, status, description, startTime, endTime, type);
    }

}
