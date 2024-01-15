package org.guidernas.guideapi.activity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ActivityRepository extends JpaRepository<Activity, Long> {

    //Selects all Activities with a specific guide as leader
    @Query("SELECT a FROM Activity a JOIN a.leaders l WHERE l.id = :guideId")
    List<Activity> findActivitiesByGuideId(@Param("guideId") Long guideId);

    List<Activity> findByHostOrganizationId(Long organizationId);
}