package com.example.school_management_software.DTO;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AddressDTO {
    private Integer teacher_id;
    @NotEmpty(message = "Cannot be empty")
    private String street;
    @NotNull(message = "Cannot be null")
    private Integer buildingNumber;
    @NotEmpty(message = "Cannot be empty")
    private String area;
}
