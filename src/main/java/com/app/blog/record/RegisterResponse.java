package com.app.blog.record;

import java.util.Set;

public record RegisterResponse(
        String firstName,
        String lastName,
        String email,
        Set role
) {
}
