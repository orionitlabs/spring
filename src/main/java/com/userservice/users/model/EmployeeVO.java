package com.userservice.users.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class EmployeeVO {
    private String employeeFirstName;
    private String employeeLastName;
    private String employeeId;
    private String employeeDepartment;
    private Integer employeeSalary;

}