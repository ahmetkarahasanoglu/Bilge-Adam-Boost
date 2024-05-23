package com.ahmet.service;

import com.ahmet.repository.DepartmentRepository;
import com.ahmet.repository.entity.Department;
import com.ahmet.utility.MyFactoryService;
import com.sun.xml.bind.v2.model.core.ID;

public class DepartmentService extends MyFactoryService<DepartmentRepository, Department, Long> {

    public DepartmentService() {
        super(new DepartmentRepository());
    }

}
