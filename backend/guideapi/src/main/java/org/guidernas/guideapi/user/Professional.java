package org.guidernas.guideapi.user;

import jakarta.persistence.MappedSuperclass;
import org.guidernas.guideapi.activity.Activity;

import java.util.List;

@MappedSuperclass
public abstract class Professional extends User{

    // Currently disabled since Im not sure if

    //private List<Activity> associatedActivities;
    //private List<Activity> activities;
    //private List<Activity> createdActivities;

}
