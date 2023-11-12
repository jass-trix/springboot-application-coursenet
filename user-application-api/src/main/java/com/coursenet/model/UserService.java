package com.coursenet.model;

public interface UserService {
    UserResponseDTO userRegistration(UserRequestDTO userRequestDTO);

    UserLoginResponseDTO userLogin(UserRequestDTO userRequestDTO);

    UserLoginResponseDTO refreshToken(String refreshToken);
}
