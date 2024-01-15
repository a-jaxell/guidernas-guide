package org.guidernas.guideapi.user.guide;

import org.guidernas.guideapi.qualification.Qualification;
import org.guidernas.guideapi.user.organization.Organization;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/api/guides")
public class GuideController {

    private final GuideService guideService;

    @Autowired
    public GuideController(GuideService guideService) {
        this.guideService = guideService;
    }

    // Get all guides
    @GetMapping
    public ResponseEntity<List<Guide>> getAllGuides() {
        return ResponseEntity.ok(guideService.getAll());
    }

    // Get a guide by ID
    @GetMapping("/{id}")
    public ResponseEntity<Guide> getGuideById(@PathVariable Long id) {
        return ResponseEntity.ok(guideService.getGuideById(id));
    }

    // Get qualifications for a guide
    @GetMapping("/{guideId}/qualifications")
    public ResponseEntity<List<Qualification>> getGuideQualificationsById(@PathVariable Long guideId) {
        return ResponseEntity.ok(guideService.getGuideQualificationsById(guideId));
    }

    // Get organizations for a guide
    @GetMapping("/{guideId}/organizations")
    public ResponseEntity<Set<Organization>> getGuideOrganizations(@PathVariable Long guideId) {
        return ResponseEntity.ok(guideService.getGuideOrganizations(guideId));
    }

    // Create a new guide
    @PostMapping
    public ResponseEntity<Guide> createGuide(@RequestBody GuideCreateDto createDto) {
        return ResponseEntity.ok(guideService.createGuide(createDto));
    }

    // Update a guide
    @PutMapping("/{id}")
    public ResponseEntity<Guide> updateGuide(@PathVariable Long id, @RequestBody GuideUpdateDto updateDto) {
        return ResponseEntity.ok(guideService.updateGuide(id, updateDto));
    }

    // Delete a guide
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteGuide(@PathVariable Long id) {
        boolean isDeleted = guideService.deleteCustomer(id);
        if (isDeleted) {
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
