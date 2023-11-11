package com.coursenet.model;

public class GenericResponse {
    private boolean status;
    private String message;

    public GenericResponse(boolean status, String message) {
        this.status = status;
        this.message = message;
    }

    public GenericResponse() {
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
