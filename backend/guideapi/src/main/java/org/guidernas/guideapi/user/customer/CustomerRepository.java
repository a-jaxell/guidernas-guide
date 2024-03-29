package org.guidernas.guideapi.user.customer;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
    @Query("SELECT c FROM Customer c LEFT JOIN FETCH c.attendedActivities WHERE c.id = :customerId")
    Optional<Customer> findByIdWithAttendedActivities(@Param("customerId") Long customerId);
}