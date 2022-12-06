package com.jirBy4.employeeManagementSys.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeDto {
    private long id;
    @NotEmpty(message = "Please enter a first name")
    private String firstName;
    @NotEmpty(message = "Please enter a last name")
    private String lastName;
    @NotEmpty(message = "Please enter an email")
    private String email;
    @NotEmpty(message = "Please enter an age")
    private int age;
    private String favColor;
    @NotEmpty(message = "Please enter a phone number")
    private Long phoneNo;
}
