package com.example.bookstoreuserservice.dto;

import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;

@Data
public class UserValidationRequest {

    @NotBlank
    @Length(min = 3, max = 16)
    private String login;
    @NotBlank
    @Length(min = 3, max = 16)
    private String password;

}
