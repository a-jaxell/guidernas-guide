package org.guidernas.guideapi.exception;

public class GuideNotFoundException extends ResourceNotFoundException {

    public GuideNotFoundException() {
        super("Guide not found");
    }
}
