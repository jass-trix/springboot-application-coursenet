package com.coursenet.configuration;

import com.coursenet.DatabaseConnection;
import com.coursenet.MySQLDatabaseConnection;
import com.coursenet.PostgreSQLDatabaseConnection;
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


}
