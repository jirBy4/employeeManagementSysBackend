package com.jirBy4.employeeManagementSys.services;

import com.jirBy4.employeeManagementSys.dtos.EmployeeDto;
import com.jirBy4.employeeManagementSys.models.Employee;
import java.util.List;

public interface EmployeeService {
    List<Employee> getAllEmployee();
    EmployeeDto getEmployeeById(Long id);
    EmployeeDto createEmployee(EmployeeDto employeeDto);
    EmployeeDto updateEmployee(EmployeeDto employeeDto, long id);
    void deleteById(Long ids);
}

