package com.dineshmane.organization_service.serviceImpl;

import com.dineshmane.organization_service.dto.OrganizationDto;
import com.dineshmane.organization_service.entity.Organization;
import com.dineshmane.organization_service.mapper.OrganizationMapper;
import com.dineshmane.organization_service.repository.OrganizationRepository;
import com.dineshmane.organization_service.service.OrganizationService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class OrganizationServiceImpl implements OrganizationService {
    private OrganizationRepository organizationRepository;

    @Override
    public OrganizationDto saveOrganization(OrganizationDto organizationDto) {
        Organization organization = OrganizationMapper.mapToOrganization(organizationDto);
        Organization savedOrg = organizationRepository.save(organization);
        return OrganizationMapper.mapToOrganizationDto(savedOrg);
    }
}
