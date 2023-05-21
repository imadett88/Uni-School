package com.emsi.schoolmangmvc.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
@Data @AllArgsConstructor @NoArgsConstructor
public class Courses {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotEmpty
    @Size(min = 6,max = 50)
    private String branch;
    @NotEmpty
    @Size(min = 6,max = 50)
    private String CourseName1;
    @NotEmpty
    @Size(min = 6,max = 50)
    private String CourseName2;
    @NotEmpty
    @Size(min = 6,max = 50)
    private String CourseName3;
    @NotEmpty
    @Size(min = 6,max = 50)
    private String CourseName4;
}
