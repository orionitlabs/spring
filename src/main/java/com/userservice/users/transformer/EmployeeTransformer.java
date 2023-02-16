package com.userservice.users.transformer;

import com.userservice.users.entity.EmployeeEntity;
import com.userservice.users.model.EmployeeVO;
import com.userservice.users.utils.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class EmployeeTransformer {
    @Autowired
    Utils utils;
    public EmployeeEntity toEmployeeEntity(EmployeeVO employeeVO){
        return EmployeeEntity.builder()
                .employeeFirstName(employeeVO.getEmployeeFirstName())
                .employeeLastName(employeeVO.getEmployeeLastName())
                .employeeId(utils.createEmployeeId())
                .employeeDepartment(employeeVO.getEmployeeDepartment())
                .employeeSalary(employeeVO.getEmployeeSalary())
                .build();
    }
    public EmployeeVO fromEmployeeEntity(EmployeeEntity employeeEntity){
        return EmployeeVO.builder()
                .employeeFirstName(employeeEntity.getEmployeeFirstName())
                .employeeLastName(employeeEntity.getEmployeeLastName())
                .employeeId(employeeEntity.getEmployeeId())
                .employeeDepartment(employeeEntity.getEmployeeDepartment())
                .employeeSalary(employeeEntity.getEmployeeSalary())
                .build();
    }
}
