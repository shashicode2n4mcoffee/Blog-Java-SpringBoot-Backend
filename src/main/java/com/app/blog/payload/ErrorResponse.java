package com.app.blog.payload;

import org.springframework.http.HttpStatus;

public class ErrorResponse {
    private String message;
    private int status;

    public ErrorResponse(String message, int httpStatus) {
        this.message = message;
        this.status = httpStatus;
    }

    public ErrorResponse() {

    }


    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "ErrorResponse{" +
                "message='" + message + '\'' +
                ", status=" + status +
                '}';
    }
}
