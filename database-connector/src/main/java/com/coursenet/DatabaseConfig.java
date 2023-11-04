package com.coursenet;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties("database-config")
public class DatabaseConfig {
  private int port;
  private String url;
  private String username;
  private String password;

  public DatabaseConfig(int port, String url, String username, String password) {
    this.port = port;
    this.url = url;
    this.username = username;
    this.password = password;
  }

  public DatabaseConfig() {
  }

  public int getPort() {
    return port;
  }

  public void setPort(int port) {
    this.port = port;
  }

  public String getUrl() {
    return url;
  }

  public void setUrl(String url) {
    this.url = url;
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }
}
