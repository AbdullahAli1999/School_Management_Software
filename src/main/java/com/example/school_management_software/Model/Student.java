package com.example.school_management_software.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@AllArgsConstructor
@Entity
@NoArgsConstructor
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotEmpty(message = "Name can not be empty")
    private String name;
    @NotNull(message = "Age can not be null")
    private Integer age;
    @NotEmpty(message = "Major can not be empty")
    private String major;

    @ManyToMany
    @JsonIgnore
    private Set<Course> courses;
}
