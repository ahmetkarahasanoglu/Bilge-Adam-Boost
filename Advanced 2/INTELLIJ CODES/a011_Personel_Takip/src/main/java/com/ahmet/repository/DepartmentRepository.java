package com.ahmet.repository;

import com.ahmet.repository.entity.Department;
import com.ahmet.utility.MyFactoryRepository;

public class DepartmentRepository extends MyFactoryRepository<Department, Long> {

    public DepartmentRepository() {
        super(new Department());
    }

}
