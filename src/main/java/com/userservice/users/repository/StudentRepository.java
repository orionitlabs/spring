package com.userservice.users.repository;

import com.userservice.users.entity.StudentEntity;
import org.bson.types.ObjectId;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StudentRepository extends CrudRepository<StudentEntity, ObjectId> {
    Optional<StudentEntity> findByStudentDepartment(String studentDepartment);

    Optional<StudentEntity> findByStudentYear(Integer studentYear);

    Optional<StudentEntity> findByStudentId(String studentId);

//    Optional<StudentEntity> findByStudentDepartmentAndStudentYear(String studentDepartment, Integer studentYear);

}
