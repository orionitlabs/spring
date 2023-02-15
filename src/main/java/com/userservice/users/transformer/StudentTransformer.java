package com.userservice.users.transformer;

import com.userservice.users.entity.StudentEntity;
import com.userservice.users.model.StudentVO;
import com.userservice.users.utils.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class StudentTransformer {
    @Autowired
    Utils utils;
    public StudentEntity toStudentEntity(StudentVO studentVO){
        return StudentEntity.builder()
                .studentFirstName(studentVO.getStudentFirstName())
                .studentLastName(studentVO.getStudentLastName())
                .studentId(utils.createStudentId())
                .studentDepartment(studentVO.getStudentDepartment())
                .studentYear(studentVO.getStudentYear())
                .studentAge(studentVO.getStudentAge())
                .build();
    }
    public StudentVO fromStudentEntity(StudentEntity studentEntity){
        return StudentVO.builder()
                .studentFirstName(studentEntity.getStudentFirstName())
                .studentLastName(studentEntity.getStudentLastName())
                .studentId(studentEntity.getStudentId())
                .studentDepartment(studentEntity.getStudentDepartment())
                .studentYear(studentEntity.getStudentYear())
                .studentAge(studentEntity.getStudentAge())
                .build();
    }
}
