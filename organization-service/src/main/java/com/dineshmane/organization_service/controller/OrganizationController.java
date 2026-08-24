package com.dineshmane.organization_service.controller;

import com.dineshmane.organization_service.dto.OrganizationDto;
import com.dineshmane.organization_service.service.OrganizationService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/organizations")
@AllArgsConstructor
public class OrganizationController {
    private OrganizationService organizationService;

    @PostMapping
    public ResponseEntity<OrganizationDto> saveOrg(@RequestBody OrganizationDto organizationDto){
        OrganizationDto saved = organizationService.saveOrganization(organizationDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(saved);
    }
}
