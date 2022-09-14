package com.example.bookstoreuserservice.dto;

import com.example.bookstoreuserservice.domain.UserStatus;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UserValidationResponse {

    private String login;
    private UserStatus status;

}
