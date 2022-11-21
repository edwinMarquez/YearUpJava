package com.yearup.week6.code.springboot.SpringBootDemoApp.service;

import com.yearup.week6.code.springboot.SpringBootDemoApp.entity.Department;

import java.util.List;

public interface DepartmentService {

    public Department saveDepartment(Department department);

    public List<Department> fetchDepartmentList();

    public Department fetchDepartmentById(Long departmentId);

    public void  deleteDepartmentId(Long departmentId);

    public Department updateDepartment(Long departmentId, Department department);

    public Department fetchDepartmentByName(String departmentName);
}
