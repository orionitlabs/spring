package com.userservice.users.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Document("students")
public class StudentEntity {
    @Id
    private ObjectId id;
    private String studentFirstName;
    private String studentLastName;
    private String studentId;
    private String studentDepartment;
    private Integer studentYear;
    private Integer studentAge;
}
