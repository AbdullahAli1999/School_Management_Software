package com.example.school_management_software.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Getter
@Setter
@Data
@AllArgsConstructor
@Entity
@NoArgsConstructor
public class Address {
    @Id
    private Integer id;
    @NotEmpty(message = "Cannot be empty")
    @Column(columnDefinition = "varchar(50) not null")
    private String area;
    @NotEmpty(message = "Can not be empty")
    @Column(columnDefinition = "varchar(50) not null")
    private String street;
    @NotNull(message = "Cannot be null")
    @Column(columnDefinition = "int not null")
    private Integer buildingNumber;

    @OneToOne
    @MapsId
    @JsonIgnore
    private Teacher teacher;
}
