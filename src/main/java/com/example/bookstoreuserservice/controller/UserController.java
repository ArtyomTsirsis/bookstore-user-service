package com.example.bookstoreuserservice.controller;

import com.example.bookstoreuserservice.core.UserValidationService;
import com.example.bookstoreuserservice.dto.UserValidationRequest;
import com.example.bookstoreuserservice.dto.UserValidationResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

    private final UserValidationService validationService;

    @PostMapping(value = "/signin")
    public UserValidationResponse signIn(@RequestBody @Valid UserValidationRequest request) {
        return validationService.validateUser(request);
    }

}
