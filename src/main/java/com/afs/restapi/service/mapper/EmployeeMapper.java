package com.afs.restapi.service.mapper;

import com.afs.restapi.entity.Employee;
import com.afs.restapi.service.dto.EmployeeRequest;
import org.springframework.beans.BeanUtils;

public class EmployeeMapper {
    public static Employee toEntity(EmployeeRequest employeeRequest) {
        Employee employee = new Employee();
        BeanUtils.copyProperties(employeeRequest, employee); // will copy from employee to employee request
        return employee;
    }
}
