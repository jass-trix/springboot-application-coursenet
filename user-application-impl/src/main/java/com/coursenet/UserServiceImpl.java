package com.coursenet;

import com.auth0.jwt.interfaces.DecodedJWT;
import com.coursenet.jwt.JwtUtil;
import com.coursenet.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Value("${salt.hash.password}")
    private String salt;

    @Autowired
    private JwtUtil jwtUtil;

    @Override
    public UserResponseDTO userRegistration(UserRequestDTO userRequestDTO) {
        User user = new User();
        user.setUsername(userRequestDTO.getUsername());
        user.setPassword(
                hashPasswordSHA256(
                        userRequestDTO.getPassword()
                )
        );
        user.setEmail("email@email.com");

        userRepository.save(user);

        UserResponseDTO userResponseDTO = new UserResponseDTO();
        userResponseDTO.setUsername(user.getUsername());
        return userResponseDTO;
    }

    private String hashPasswordSHA256(String password) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            md.update(salt.getBytes());
            byte[] hashedPassword = md.digest(password.getBytes());
            return new String(hashedPassword);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public UserLoginResponseDTO userLogin(UserRequestDTO userRequestDTO) {
        Optional<User> user = userRepository.findByUsernameAndPassword(
                userRequestDTO.getUsername(),
                hashPasswordSHA256(userRequestDTO.getPassword())
        );

        if (user.isEmpty()) {
            return null;
        }

        // generate JWT Token
        // return token ke controller
        String accessToken = jwtUtil.generateJWTToken(userRequestDTO.getUsername(), "ACCESS_TOKEN");
        String refreshToken = jwtUtil.generateJWTToken(userRequestDTO.getUsername(), "REFRESH_TOKEN");

        UserLoginResponseDTO userLoginResponseDTO = new UserLoginResponseDTO();
        userLoginResponseDTO.setAccessToken(accessToken);
        userLoginResponseDTO.setRefreshToken(refreshToken);
        return userLoginResponseDTO;
    }

    @Override
    public UserLoginResponseDTO refreshToken(String refreshToken) {
        DecodedJWT decodedJWT = jwtUtil.verifyJWTToken(refreshToken);
        if (decodedJWT.getClaim("type").asString().equals("REFRESH_TOKEN")) {
            String accessToken = jwtUtil.generateJWTToken(
                    decodedJWT.getSubject(), "ACCESS_TOKEN"
            );
            UserLoginResponseDTO userLoginResponseDTO = new UserLoginResponseDTO();
            userLoginResponseDTO.setAccessToken(accessToken);
            userLoginResponseDTO.setRefreshToken(refreshToken);

            return userLoginResponseDTO;
        }

        return null;
    }
}
