package com.coursenet.jwt;

import com.auth0.jwt.interfaces.DecodedJWT;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

import java.io.IOException;

public class JwtSecurityFilter extends BasicAuthenticationFilter {
    private JwtUtil jwtUtil;

    public JwtSecurityFilter(AuthenticationManager authenticationManager, JwtUtil jwtUtil) {
        super(authenticationManager);
        this.jwtUtil = jwtUtil;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws IOException, ServletException {
        UsernamePasswordAuthenticationToken authentication = getAuthentication(request);
        SecurityContextHolder.getContext().setAuthentication(authentication);

        chain.doFilter(request, response); // artinya melanjutkan request / response ke controller
    }

    private UsernamePasswordAuthenticationToken getAuthentication(HttpServletRequest request) {
        String token = request.getHeader("Authorization");
        if (token == null || !token.startsWith("Bearer")) {
            return null;
        }

        DecodedJWT decodedJWT = jwtUtil.verifyJWTToken(token.replace("Bearer ", ""));
        String userName = decodedJWT.getSubject();
        String tokenType = decodedJWT.getClaim("type").asString();
        if (tokenType.equalsIgnoreCase("REFRESH_TOKEN")) {
            return null;
        }

        return new UsernamePasswordAuthenticationToken(userName, null, null);
    }
}
