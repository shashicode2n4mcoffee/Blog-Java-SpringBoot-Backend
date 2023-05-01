package com.app.blog.record;

public record RegisterRequest(
        String firstName,
        String lastName,
        String email,
        String password,
        String role
) {

}
