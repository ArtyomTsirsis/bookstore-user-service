package com.example.bookstoreuserservice.core;

import com.example.bookstoreuserservice.domain.User;
import com.example.bookstoreuserservice.domain.UserStatus;
import com.example.bookstoreuserservice.dto.UserValidationRequest;
import com.example.bookstoreuserservice.dto.UserValidationResponse;
import com.example.bookstoreuserservice.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserValidationService {

    private final UserRepository repository;

    @Transactional
    public UserValidationResponse validateUser(UserValidationRequest request) {
        UserValidationResponse response = new UserValidationResponse(request.getLogin(), UserStatus.USER);
        Optional<User> user = repository.findById(request.getLogin());
        if (user.isEmpty()) {
            response.setStatus(UserStatus.INCORRECT_USER);
        } else if (!user.get().getPassword().equals(request.getPassword())) {
            response.setStatus(UserStatus.INCORRECT_PASSWORD);
        } else if (user.get().isAdmin()) {
            response.setStatus(UserStatus.ADMIN);
        }
        return response;
    }

}