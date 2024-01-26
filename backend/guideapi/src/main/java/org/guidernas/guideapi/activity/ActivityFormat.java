package org.guidernas.guideapi.activity;

public enum ActivityFormat {
    EXPEDITION("Expedition"),
    MULTIDAY("Multiday"),
    DAYTRIP("Daytrip"),
    SEMINAR("Seminar"),
    CLASS("Class");

    private final String value;

    ActivityFormat(String value) {
        this.value = value;
    }

    public static ActivityFormat fromString(String text) {
        for (ActivityFormat b : ActivityFormat.values()) {
            if (b.value.equalsIgnoreCase(text)) {
                return b;
            }
        }
        throw new IllegalArgumentException("No format with " + text + " found");
    }

    public String getValue() {
        return value;
    }
}
