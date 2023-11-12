package com.coursenet.configuration;

import com.auth0.jwt.algorithms.Algorithm;
import com.coursenet.DatabaseConnection;
import com.coursenet.MySQLDatabaseConnection;
import com.coursenet.PostgreSQLDatabaseConnection;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LocalConfiguration {
  // bean untuk MySQL Database Connection
  @Bean
  public DatabaseConnection mySQLDatabaseConnection() {
    return new MySQLDatabaseConnection();
  }

  // bean untuk PostgreSQL Database Connection
  @Bean
  public DatabaseConnection postgreSQLDatabaseConnection() {
    return new PostgreSQLDatabaseConnection();
  }

  @Value("${jwt.token.secret}")
  private String secretKey;

  @Bean
  public Algorithm getKeyAlgorithm() {
    return Algorithm.HMAC256(secretKey);
  }
}
