package org.guidernas.guideapi.activity;

public enum ActivityType {
    SKIING("Skiing"),
    HIKING("Hiking"),
    KAYAKING("Kayaking");

    private final String value;

    ActivityType(String value) {
        this.value = value;
    }

    public String getValue(){
        return value;
    }

    public static ActivityType fromString(String text){
        for(ActivityType b : ActivityType.values()){
            if(b.value.equalsIgnoreCase(text)){
                return b;
            }
        }
        throw new IllegalArgumentException("No type with " + text + " found.");
    }
}
