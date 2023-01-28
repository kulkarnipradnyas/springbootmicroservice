package com.example.demo.service.impl;

import com.example.demo.dto.DepartmentDto;
import com.example.demo.entity.Department;
import com.example.demo.repository.DepartmentRepository;
import com.example.demo.service.DepartmentService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class DepartmentServiceImpl implements DepartmentService {

    private DepartmentRepository departmentRepository;
    @Override
    public DepartmentDto saveDepartment(DepartmentDto departmentDto) {
        //convert Department dto to department jpa entity
        Department department=new Department(
                departmentDto.getId(),
                departmentDto.getDepartmentName(),
                departmentDto.getDepartmentDescription(),
                departmentDto.getDepartmentCode()
        );
        Department saveDpt=  departmentRepository.save(department);
        DepartmentDto saveDepartmentDto = new DepartmentDto(saveDpt.getId(),
                saveDpt.getDepartmentName(),
                saveDpt.getDepartmentDescription(),
                saveDpt.getDepartmentCode());
        return saveDepartmentDto;
    }

    @Override
    public DepartmentDto getDepartmentByDepartmentCode(String departmentCode) {
        List<Department> dpt= departmentRepository.findByDepartmentCode(departmentCode);
        Department department =dpt.get(0);
        DepartmentDto departmentDto= new DepartmentDto(
                department.getId(),
                department.getDepartmentName(),
                department.getDepartmentDescription(),
                department.getDepartmentCode()
        );
        return departmentDto;
    }
}
