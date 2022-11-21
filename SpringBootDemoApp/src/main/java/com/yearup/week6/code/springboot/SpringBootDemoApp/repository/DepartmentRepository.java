package com.yearup.week6.code.springboot.SpringBootDemoApp.repository;

import com.yearup.week6.code.springboot.SpringBootDemoApp.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DepartmentRepository extends JpaRepository<Department,Long> {
    public Department findByDepartmentName(String departmentName);
}
