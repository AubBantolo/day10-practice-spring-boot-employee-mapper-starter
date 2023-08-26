package com.afs.restapi.service.mapper;

import com.afs.restapi.entity.Employee;

import java.util.List;

public class CompanyResponse {

    private Long id;

    private String name;

    private Integer employeesCount;

    private List<Employee> employees;
    public CompanyResponse(){

    }
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getEmployeesCount() {
        return employeesCount;
    }

    public void setEmployeesCount(Integer employeesCount) {
        this.employeesCount = employeesCount;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public CompanyResponse setEmployees(List<Employee> employees) {
        this.employees = employees;
        return this;
    }
}
