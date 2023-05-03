package com.app.blog.exception;

public class ResourceAlreadyExistsException extends RuntimeException{

    public ResourceAlreadyExistsException(String message){
        super(message);
    }
}
