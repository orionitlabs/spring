package com.userservice.users.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class StudentVO {
    private String studentFirstName;
    private String studentLastName;
    private String studentId;
    private String studentDepartment;
    private Integer studentYear;
    private Integer studentAge;
}
