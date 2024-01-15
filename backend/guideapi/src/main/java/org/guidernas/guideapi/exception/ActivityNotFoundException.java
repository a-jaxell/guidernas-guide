package org.guidernas.guideapi.exception;

public class ActivityNotFoundException extends ResourceNotFoundException {
    public ActivityNotFoundException() {
        super("Activity not found");
    }
}
