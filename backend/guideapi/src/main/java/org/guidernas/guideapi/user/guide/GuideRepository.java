package org.guidernas.guideapi.user.guide;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface GuideRepository extends JpaRepository<Guide, Long> {

    @Query("SELECT g FROM Guide g JOIN FETCH g.associatedOrganizations WHERE g.id = :guideId")
    Optional<Guide> findByIdWithOrganizations(@Param("guideId") Long guideId);
}