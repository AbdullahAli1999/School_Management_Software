package com.example.school_management_software.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;

import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@Entity
@NoArgsConstructor
public class Teacher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotEmpty(message = "Cannot be empty")
    @Size(min = 3,message = "The Length can not be less than 3")
    @Column(columnDefinition = "varchar(30) not null")
    private String name;
    @NotNull(message = "Cannot be null")
    @Min(value = 18,message = "The can not be less than 18")
    @Column(columnDefinition = "int not null")
    private Integer age;
    @NotEmpty(message = "Can not be empty")
    @Email
    @Column(columnDefinition = "varchar(50) not null unique")
    private String email;
    @NotNull(message = "Can not be null")
    @Min(value = 3500,message = "Can not be less than 3500 SAR")
    @Column(columnDefinition = "int not null")
    private Integer salary;

    @OneToOne(cascade = CascadeType.ALL,mappedBy = "teacher")
    @PrimaryKeyJoinColumn
    private Address address;

    @OneToMany(cascade = CascadeType.ALL,mappedBy = "teacher")
    private Set<Course> course;

}
