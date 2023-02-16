package com.userservice.users.repository;

import com.userservice.users.entity.EmployeeEntity;
import org.bson.types.ObjectId;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EmployeeRepository extends CrudRepository<EmployeeEntity, ObjectId> {

    Optional<EmployeeEntity> findByEmployeeId(String EmployeeId);

    List<EmployeeEntity> findAllByEmployeeDepartmentAndEmployeeSalary(String employeeDepartment, Integer employeeSalary);
}

