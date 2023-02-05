package com.example.demo.service;

import com.example.demo.dto.DepartmentDto;
import com.example.demo.dto.OrganizationDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "ORGANIZATION-SERVICE")
public interface OrganizationApiClient {
    @GetMapping("api/organizations/{code}")
    OrganizationDto getOrganizationCode(@PathVariable("code") String code);
}

