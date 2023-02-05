package com.example.organisation.organisationservice.service.impl;

import com.example.organisation.organisationservice.dto.OrganizationDto;
import com.example.organisation.organisationservice.entity.Organization;
import com.example.organisation.organisationservice.mapper.OrganizationMapper;
import com.example.organisation.organisationservice.repository.OrganizationRepository;
import com.example.organisation.organisationservice.service.OrganizationService;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class OrganizationServiceImpl implements OrganizationService {

    private OrganizationRepository organizationRepository;
    @Override
    public OrganizationDto saveOrganization(OrganizationDto organizationDto) {
        Organization organization = OrganizationMapper.mapToOrganization(organizationDto);
        Organization saveOrg=organizationRepository.save(organization);
        return OrganizationMapper.mapToOrganizationDto(saveOrg);
    }

    @Override
    public OrganizationDto getOrganizationByCode(String organizationCode) {
        Organization organization= organizationRepository.findByOrganizationCode(organizationCode);
        return OrganizationMapper.mapToOrganizationDto(organization);
    }
}
