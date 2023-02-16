package com.userservice.users.service;

import com.userservice.users.entity.StudentEntity;
import com.userservice.users.model.StudentVO;
import com.userservice.users.repository.StudentRepository;
import com.userservice.users.transformer.StudentTransformer;
import com.userservice.users.utils.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class StudentService {
    @Autowired
    StudentRepository studentRepository;

    @Autowired
    Utils utils;

    @Autowired
    StudentTransformer studentTransformer;

    List<StudentVO> students = new ArrayList<StudentVO>();
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

//    public List<StudentVO> getStudentByDeptAndYear(String studentDepartment, Integer studentYear){
//        Optional<StudentEntity> studentByDept = studentRepository.findByStudentDepartment(studentDepartment);
//        if(studentByDept.isPresent()){
//            Optional<StudentEntity> studentByYear = studentRepository.findByStudentYear(studentYear);
//            if(studentByYear.isPresent()) {
//                students.add(studentTransformer.fromStudentEntity(studentByYear.get()));
//                return students;
//            }
//            else {
//                throw new RuntimeException("Students not present");
//            }
//        }
//        else {
//            throw new RuntimeException("Students not present");
//        }
//    }

    public List<StudentVO> getStudentByDeptAndYear(String studentDepartment, Integer studentYear){
//        Optional<StudentEntity> student = studentRepository.findByStudentDepartmentAndStudentYear(studentDepartment, studentYear);
        Iterable<StudentEntity> student = studentRepository.findAllByStudentDepartmentAndStudentYear(studentDepartment, studentYear);
//        if(!student.isEmpty()){
//            students.add(studentTransformer.fromStudentEntity(student.get()));
//            return students;
//        }
//        else {
//            throw new RuntimeException("Students not present");
//        }
        for(StudentEntity studentEntity : student){
            students.add(studentTransformer.fromStudentEntity(studentEntity));
        }
        return students;
    }
}
