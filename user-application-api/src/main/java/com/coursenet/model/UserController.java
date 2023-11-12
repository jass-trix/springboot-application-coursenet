package com.coursenet.model;

import org.springframework.http.ResponseEntity;

public interface UserController {
    ResponseEntity<UserResponseDTO> userRegistration(UserRequestDTO userRequestDTO);

    ResponseEntity<UserLoginResponseDTO> userLogin(UserRequestDTO userRequestDTO);

    ResponseEntity<UserLoginResponseDTO> refreshLogin(String refreshToken);
}
