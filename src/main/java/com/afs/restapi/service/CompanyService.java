package com.afs.restapi.service;

import com.afs.restapi.entity.Company;
import com.afs.restapi.entity.Employee;
import com.afs.restapi.exception.CompanyNotFoundException;
import com.afs.restapi.repository.CompanyRepository;
import com.afs.restapi.repository.EmployeeRepository;
import com.afs.restapi.service.dto.CompanyRequest;
import com.afs.restapi.service.mapper.CompanyMapper;
import com.afs.restapi.service.mapper.CompanyResponse;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CompanyService {
    private final CompanyRepository companyRepository;
    private final EmployeeRepository employeeRepository;

    public CompanyService(CompanyRepository companyRepository, EmployeeRepository employeeRepository) {
        this.companyRepository = companyRepository;
        this.employeeRepository = employeeRepository;
    }

    public List<Company> findAll() {
        return companyRepository.findAll();
    }

    public CompanyResponse findById(Long id) {
        Company company = companyRepository.findById(id)
                .orElseThrow(CompanyNotFoundException::new);

        return CompanyMapper.toResponse(company);
    }

    public List<Company> findByPage(Integer pageNumber, Integer pageSize) {
        return companyRepository.findAll(PageRequest.of(pageNumber-1, pageSize)).stream()
                .collect(Collectors.toList());
    }

    public CompanyResponse update(Long id, CompanyRequest companyRequest) {
        Company toBeUpdatedCompany = companyRepository.findById(id)
                .orElseThrow(CompanyNotFoundException::new);
        Company company = CompanyMapper.toEntity(toBeUpdatedCompany, companyRequest);

        return CompanyMapper.toResponse(companyRepository.save(company));
    }

    public CompanyResponse create(CompanyRequest companyRequest) {
        Company company = CompanyMapper.toEntity(null, companyRequest);
        return CompanyMapper.toResponse(companyRepository.save(company));
    }

    public List<Employee> findEmployeesByCompanyId(Long id) {
        return employeeRepository.findAllByCompanyId(id);
    }

    public void delete(Long id) {
        companyRepository.deleteById(id);
    }
}
