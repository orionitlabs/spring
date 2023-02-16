package com.userservice.users.service;

import com.userservice.users.entity.EmployeeEntity;
import com.userservice.users.model.EmployeeVO;
import com.userservice.users.repository.EmployeeRepository;
import com.userservice.users.transformer.EmployeeTransformer;
import com.userservice.users.utils.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class EmployeeService {
    @Autowired
    EmployeeRepository employeeRepository;

    @Autowired
    Utils utils;

    @Autowired
    EmployeeTransformer employeeTransformer;

    public EmployeeVO addNewEmployee(EmployeeVO employeeVO){
        return employeeTransformer.fromEmployeeEntity(employeeRepository.save(employeeTransformer.toEmployeeEntity(employeeVO)));
    }
    public List<EmployeeVO> getEmployeeByDeptAndSalary(String employeeDepartment, Integer employeeSalary){
        List<EmployeeEntity> employeeList = employeeRepository.findAllByEmployeeDepartmentAndEmployeeSalary(employeeDepartment, employeeSalary);
        if(!employeeList.isEmpty()) {
            return employeeList.stream().map(e->employeeTransformer.fromEmployeeEntity(e)).collect(Collectors.toList());
        }
        else {
            throw new RuntimeException("Employees not working");
        }

    }

    public EmployeeVO getEmployeeById(String employeeId){
        Optional<EmployeeEntity> employee = employeeRepository.findByEmployeeId(employeeId);
        if(employee.isPresent()){
            return employeeTransformer.fromEmployeeEntity(employee.get());
        }else{
            throw new RuntimeException("Employee not working");
        }
    }
}
