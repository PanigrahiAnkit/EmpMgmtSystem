package com.example.apimodule.dto;

import jakarta.persistence.Id;
import lombok.*;


@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Data
public class EmployeeDto {
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
}
