package org.guidernas.guideapi.user.organization;

import org.guidernas.guideapi.user.guide.Guide;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/api/organizations")
public class OrganizationController {

    private final OrganizationService organizationService;

    @Autowired
    public OrganizationController(OrganizationService organizationService) {
        this.organizationService = organizationService;
    }

    // Get all organizations
    @GetMapping
    public ResponseEntity<List<Organization>> getAllOrganizations() {
        return ResponseEntity.ok(organizationService.getAllOrganizations());
    }

    // Get an organization by ID
    @GetMapping("/{id}")
    public ResponseEntity<Organization> getOrganizationById(@PathVariable Long id) {
        return ResponseEntity.ok(organizationService.getOrganizationById(id));
    }

    // Get guides associated with an organization
    @GetMapping("/{organizationId}/guides")
    public ResponseEntity<Set<Guide>> getGuidesByOrganization(@PathVariable Long organizationId) {
        return ResponseEntity.ok(organizationService.getGuidesByOrganization(organizationId));
    }

    // Create a new organization
    @PostMapping
    public ResponseEntity<Organization> createOrganization(@RequestBody OrganizationCreateDto createDto) {
        return ResponseEntity.ok(organizationService.createOrganization(createDto));
    }

    // Update an organization
    @PutMapping("/{id}")
    public ResponseEntity<Organization> updateOrganization(@PathVariable Long id, @RequestBody OrganizationUpdateDto updateDto) {
        return ResponseEntity.ok(organizationService.updateOrganization(id, updateDto));
    }

    // Delete an organization
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteOrganization(@PathVariable Long id) {
        boolean isDeleted = organizationService.deleteCustomer(id);
        if (isDeleted) {
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
