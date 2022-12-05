package com.jirBy4.employeeManagementSys.services.serviceimplementation;

import com.jirBy4.employeeManagementSys.dtos.EmployeeDto;
import com.jirBy4.employeeManagementSys.exceptions.EmployeeNotFoundException;
import com.jirBy4.employeeManagementSys.models.Employee;
import com.jirBy4.employeeManagementSys.repository.EmployeeSysRepository;
import com.jirBy4.employeeManagementSys.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class EmployeeServiceImplementation implements EmployeeService {
    private EmployeeSysRepository employeeSysRepository;
    @Autowired
    public EmployeeServiceImplementation(EmployeeSysRepository employeeSysRepository) {
        this.employeeSysRepository = employeeSysRepository; }

    @Override
    public List<Employee> getAllEmployee() {
        return employeeSysRepository.findAll();
    }

    @Override
    public EmployeeDto getEmployeeById(Long id) {
        Employee employee = employeeSysRepository.findById(id)
                .orElseThrow(() -> new EmployeeNotFoundException("Employee could not be found by id"));
        return mapToDto(employee);
    }

    @Override
    public EmployeeDto createEmployee(EmployeeDto employeeDto) {
        Employee newEmployee = employeeSysRepository.save(mapToEntity(employeeDto));
        return mapToDto(newEmployee);
    }

    @Override
    public EmployeeDto updateEmployee(EmployeeDto employeeDto, long id) {
        Employee employee = employeeSysRepository.findById(id)
                .orElseThrow(() -> new EmployeeNotFoundException("Employee could not updated; id doesn't exist"));
        employee.setFirstName(employeeDto.getFirstName());
        employee.setLastName(employeeDto.getLastName());
        employee.setEmail(employeeDto.getEmail());
        employee.setAge(employeeDto.getAge());
        employee.setFavColor(employeeDto.getFavColor());
        employee.setPhoneNo(employeeDto.getPhoneNo());

        Employee updatedEmployee = employeeSysRepository.save(employee);
        return mapToDto(updatedEmployee);
    }

    @Override
    public void deleteById(Long id) {
        Employee employee = employeeSysRepository.findById(id)
                .orElseThrow(() -> new EmployeeNotFoundException("Employee can't be found or deleted"));
        employeeSysRepository.delete(employee);
    }

    private EmployeeDto mapToDto(Employee employee) {
        EmployeeDto newEmployeeDto = new EmployeeDto();
        newEmployeeDto.setId(employee.getId());
        newEmployeeDto.setFirstName(employee.getFirstName());
        newEmployeeDto.setLastName(employee.getLastName());
        newEmployeeDto.setEmail(employee.getEmail());
        newEmployeeDto.setAge(employee.getAge());
        newEmployeeDto.setFavColor(employee.getFavColor());
        newEmployeeDto.setPhoneNo(employee.getPhoneNo());
        return newEmployeeDto;
    }

    private Employee mapToEntity(EmployeeDto employeeDto){
        Employee employee = new Employee();
        employee.setFirstName(employeeDto.getFirstName());
        employee.setLastName(employeeDto.getLastName());
        employee.setAge(employeeDto.getAge());
        employee.setEmail(employeeDto.getEmail());
        employee.setFavColor(employeeDto.getFavColor());
        employee.setPhoneNo(employeeDto.getPhoneNo());
        return employee;
    }

}
