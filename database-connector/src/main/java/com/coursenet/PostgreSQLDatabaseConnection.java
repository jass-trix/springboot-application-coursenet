package com.coursenet;

public class PostgreSQLDatabaseConnection implements DatabaseConnection {
  @Override
  public void select() {
    System.out.println("PostgreSQLDatabaseConnection.select()");
  }

  @Override
  public void join() {
    System.out.println("PostgreSQLDatabaseConnection.join()");

  }

  @Override
  public void insert() {
    System.out.println("PostgreSQLDatabaseConnection.insert()");
  }

  @Override
  public void update() {
    System.out.println("PostgreSQLDatabaseConnection.update()");
  }

  @Override
  public void delete() {
    System.out.println("PostgreSQLDatabaseConnection.delete()");
  }
}
