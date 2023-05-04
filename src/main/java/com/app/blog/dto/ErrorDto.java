package com.app.blog.dto;

public class ErrorDto {
    private String message;
    private int status;

    public ErrorDto(String message, int httpStatus) {
        this.message = message;
        this.status = httpStatus;
    }

    public ErrorDto() {

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
