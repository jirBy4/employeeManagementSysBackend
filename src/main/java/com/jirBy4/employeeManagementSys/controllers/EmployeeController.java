package com.jirBy4.employeeManagementSys.controllers;

import com.jirBy4.employeeManagementSys.dtos.EmployeeDto;
import com.jirBy4.employeeManagementSys.models.Employee;
import com.jirBy4.employeeManagementSys.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/")
public class EmployeeController {
    private EmployeeService employeeService;
    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }
    @GetMapping("employees/getAll")
    public List<Employee> getAllEmployees(){
        return employeeService.getAllEmployee();
    }

    @GetMapping("employees/{id}")
    public ResponseEntity<EmployeeDto> getEmployeeById(@PathVariable long id){
        return ResponseEntity.ok(employeeService.getEmployeeById(id));
    }

    @PostMapping("employees/create")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<EmployeeDto> createEmployee(@RequestBody EmployeeDto employeeDto){
        return new ResponseEntity<>(employeeService.createEmployee(employeeDto), HttpStatus.CREATED);
    }

    @PutMapping("employees/update/{id}")
    public ResponseEntity<EmployeeDto> updateEmployee(@RequestBody EmployeeDto employeeDto, @PathVariable("id") long id){
        EmployeeDto response = employeeService.updateEmployee(employeeDto, id);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
    @DeleteMapping("employees/delete/{id}")
    public ResponseEntity<String> deletePokemon(@PathVariable("id") long id) {
        employeeService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
