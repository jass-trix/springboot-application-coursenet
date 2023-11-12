package com.coursenet.jwt;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

@Component
public class JwtUtil {
    @Value("${jwt.token.issuer}")
    private String issuer;
    @Value("${jwt.token.accessExpiration}")
    private int accessTokenExpiration;
    @Value("${jwt.token.refreshExpiration}")
    private int refreshTokenExpiration;

    @Autowired
    private Algorithm algorithm;

    public DecodedJWT verifyJWTToken(String token){
        JWTVerifier verifier = JWT.require(algorithm).build();
        /**
         * Header Authorization --> Bearer <nilai_token>.
         * Token yang mau dicek, adalah hanya <nilai_token>, "Bearer" nya akan dihapus
         * token Bearer <nilai_token> --> <nilai_token>
         * */
        return verifier.verify(token.replace("Bearer ", ""));
    }

    public String generateJWTToken(String userName, String type){
        // type menentukan apakah kita mau generate REFRESH_TOKEN / ACCESS_TOKEN
        LocalDateTime issuedDateTime = LocalDateTime.now();
        int valid = 0;
        if (type.equals("ACCESS_TOKEN")) {
            valid = accessTokenExpiration;
        } else if (type.equals("REFRESH_TOKEN")) {
            valid = refreshTokenExpiration;
        }

        return JWT.create()
                .withIssuer(issuer)
                .withSubject(userName)
                .withIssuedAt(Date.from(issuedDateTime.atZone(ZoneId.systemDefault()).toInstant()))
                .withExpiresAt(Date.from(issuedDateTime.plusSeconds(valid).atZone(ZoneId.systemDefault()).toInstant()))
                .withClaim("type", type)
                .sign(algorithm);
    }
}
