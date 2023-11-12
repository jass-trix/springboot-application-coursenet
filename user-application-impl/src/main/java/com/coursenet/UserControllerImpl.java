package com.coursenet;

import com.coursenet.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value="/users", consumes = "application/json", produces = "application/json")
public class UserControllerImpl implements UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/registration")
    @Override
    public ResponseEntity<UserResponseDTO> userRegistration(@RequestBody UserRequestDTO userRequestDTO) {
        UserResponseDTO userResponseDTO = userService.userRegistration(userRequestDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(userResponseDTO);
    }

    @PostMapping("/login")
    @Override
    public ResponseEntity<UserLoginResponseDTO> userLogin(@RequestBody UserRequestDTO userRequestDTO) {
        UserLoginResponseDTO userLoginResponseDTO = userService.userLogin(userRequestDTO);
        if (userLoginResponseDTO == null) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(null);
        }

        return ResponseEntity.status(HttpStatus.OK).body(userLoginResponseDTO);
    }

    @PostMapping("/refresh-token")
    @Override
    public ResponseEntity<UserLoginResponseDTO> refreshLogin(@RequestHeader("Authorization") String refreshToken) {
        UserLoginResponseDTO userLoginResponseDTO = userService.refreshToken(refreshToken);
        if (userLoginResponseDTO == null) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(null);
        }
        return ResponseEntity.ok(userLoginResponseDTO);
    }
}
