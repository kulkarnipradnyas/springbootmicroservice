package com.example.demo.controller;


import com.example.demo.dto.DepartmentDto;
import com.example.demo.service.DepartmentService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/departments")
@AllArgsConstructor
public class DepartmentController {
    private DepartmentService departmentService;
    //build save department

    @PostMapping
    public ResponseEntity<DepartmentDto> saveDepartment(@RequestBody DepartmentDto departmentDto){
        DepartmentDto savedDpt=departmentService.saveDepartment(departmentDto);
        return new ResponseEntity<DepartmentDto>(savedDpt,HttpStatus.CREATED);
    }

    @GetMapping("{department-code}")
    public ResponseEntity<DepartmentDto> getDepartment(@PathVariable("department-code") String departmentCode){
        DepartmentDto dpt=departmentService.getDepartmentByDepartmentCode(departmentCode);
        return new ResponseEntity<DepartmentDto>(dpt,HttpStatus.OK);
    }

}
