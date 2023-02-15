package com.userservice.users.controller;

import com.userservice.users.model.StudentVO;
import com.userservice.users.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/v1/students")
public class StudentController {
    @Autowired
    StudentService studentService;

    @PostMapping(path = "/addStudent", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public StudentVO addNewStudent(@RequestBody StudentVO studentVO){
        return studentService.addNewStudent(studentVO);
    }

    @GetMapping(path = "/getStudentById", produces = MediaType.APPLICATION_JSON_VALUE)
    public StudentVO getStudentById(@RequestParam(required = true, defaultValue = "") String studentId){
        return studentService.getStudentById(studentId);
    }

    @GetMapping(path = "/getStudentByDeptAndYear", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<StudentVO> getStudentByDeptAndYear(@RequestParam(required = true, defaultValue = "") String studentDepartment, String studentYear){
        return studentService.getStudentByDeptAndYear(studentDepartment, studentYear);
    }
}
