package com.userservice.users.repository;

import com.userservice.users.entity.EmployeeEntity;
import org.bson.types.ObjectId;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EmployeeRepository extends CrudRepository<EmployeeEntity, ObjectId> {
    Optional<EmployeeEntity> findByEmployeeDepartment(String EmployeeDepartment);

    Optional<EmployeeEntity> findByEmployeeSalary(String employeesalary);

    Optional<EmployeeEntity> findByEmployeeId(String EmployeeId);
}

