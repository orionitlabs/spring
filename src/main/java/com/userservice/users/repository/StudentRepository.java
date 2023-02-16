package com.userservice.users.repository;

import com.userservice.users.entity.StudentEntity;
import org.bson.types.ObjectId;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository
public interface StudentRepository extends CrudRepository<StudentEntity, ObjectId> {

    Optional<StudentEntity> findByStudentId(String studentId);

    List<StudentEntity> findAllByStudentDepartmentAndStudentYear(String studentDepartment, Integer studentYear);
}
