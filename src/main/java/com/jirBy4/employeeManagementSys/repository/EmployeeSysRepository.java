package com.jirBy4.employeeManagementSys.repository;

import com.jirBy4.employeeManagementSys.models.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeSysRepository extends JpaRepository<Employee, Long> {

}
