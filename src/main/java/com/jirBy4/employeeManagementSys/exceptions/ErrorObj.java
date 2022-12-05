package com.jirBy4.employeeManagementSys.exceptions;

import lombok.Data;

import java.util.Date;

@Data
public class ErrorObj {
    private Integer statusCode;
    private String message;
    private Date timestamp;
}
