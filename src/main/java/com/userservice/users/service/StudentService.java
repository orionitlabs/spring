package com.userservice.users.service;

import com.userservice.users.entity.StudentEntity;
import com.userservice.users.model.StudentVO;
import com.userservice.users.repository.StudentRepository;
import com.userservice.users.transformer.StudentTransformer;
import com.userservice.users.utils.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class StudentService {
    @Autowired
    StudentRepository studentRepository;

    @Autowired
    Utils utils;

    @Autowired
    StudentTransformer studentTransformer;

    public StudentVO addNewStudent(StudentVO studentVO){
        return studentTransformer.fromStudentEntity(studentRepository.save(studentTransformer.toStudentEntity(studentVO)));
    }

    public StudentVO getStudentById(String studentId){
        Optional<StudentEntity> student = studentRepository.findByStudentId(studentId);
        if(student.isPresent()){
            return studentTransformer.fromStudentEntity(student.get());
        }else{
            throw new RuntimeException("Student not present");
        }
    }

    public List<StudentVO> getStudentByDeptAndYear(String studentDepartment, Integer studentYear){
        List<StudentEntity> studentList = studentRepository.findAllByStudentDepartmentAndStudentYear(studentDepartment, studentYear);
        if(!studentList.isEmpty()){
            return studentList.stream().map(e->studentTransformer.fromStudentEntity(e)).collect(Collectors.toList());
        }
        else {
            throw new RuntimeException("Students not present");
        }
    }
}
