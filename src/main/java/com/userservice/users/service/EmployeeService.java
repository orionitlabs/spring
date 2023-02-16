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

@Service
public class EmployeeService {
    @Autowired
    EmployeeRepository employeeRepository;

    @Autowired
    Utils utils;

    @Autowired
    EmployeeTransformer employeeTransformer;

    List<EmployeeVO> employees;
    public EmployeeVO addNewEmployee(EmployeeVO employeeVO){
        return employeeTransformer.fromEmployeeEntity(employeeRepository.save(employeeTransformer.toEmployeeEntity(employeeVO)));
    }
    public List<EmployeeVO> getEmployeeByDeptAndSalary(String employeeDepartment, String employeeSalary){
        Optional<EmployeeEntity> employeeByDept = employeeRepository.findByEmployeeDepartment(employeeDepartment);
        if(employeeByDept.isPresent()){
            Optional<EmployeeEntity> employeeBySalary = employeeRepository.findByEmployeeSalary(employeeSalary);
            if(employeeBySalary.isPresent()) {
                employees.add(employeeTransformer.fromEmployeeEntity(employeeBySalary.get()));
                return employees;
            }
            else {
                throw new RuntimeException("Employees not present");
            }
        }
        else {
            throw new RuntimeException("Employees not present");
        }
    }

    public EmployeeVO getEmployeeById(String employeeId){
        Optional<EmployeeEntity> employee = employeeRepository.findByEmployeeId(employeeId);
        if(employee.isPresent()){
            return employeeTransformer.fromEmployeeEntity(employee.get());
        }else{
            throw new RuntimeException("Employee not present");
        }
    }
}
