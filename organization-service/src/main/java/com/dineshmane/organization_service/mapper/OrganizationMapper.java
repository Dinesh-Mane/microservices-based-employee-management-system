package com.dineshmane.organization_service.mapper;

import com.dineshmane.organization_service.dto.OrganizationDto;
import com.dineshmane.organization_service.entity.Organization;

public class OrganizationMapper {

    public static OrganizationDto mapToOrganization(Organization organization){
        return new OrganizationDto(
                organization.getId(),
                organization.getOrgName(),
                organization.getOrgDescription(),
                organization.getOrgCode(),
                organization.getCreatedDate()
        );
    }

    public static Organization mapToOrganization(OrganizationDto organizationDto){
        return new Organization(
                organizationDto.getId(),
                organizationDto.getOrgName(),
                organizationDto.getOrgDescription(),
                organizationDto.getOrgCode(),
                organizationDto.getCreatedDate()
        );
    }
}
