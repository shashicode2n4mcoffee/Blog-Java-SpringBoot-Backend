package com.app.blog.payload;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import org.hibernate.annotations.NaturalId;

public class UserDto {

    private Long userId;
    @NotNull
    @Size(min=3, max = 50)
    private String firstName;
    @NotNull
    @NotEmpty
    @Size(min = 3, max = 50)
    private String lastName;
    @Email
    @Size(min = 3, max = 100)
    private String email;
    @NotNull
    @Size(min = 4, max = 100)
    private String password;
    private boolean isEnabled = false;

    @NotNull
    @Size(min = 5, max = 100)
    private String about;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isEnabled() {
        return isEnabled;
    }

    public void setEnabled(boolean enabled) {
        isEnabled = enabled;
    }

    public String getAbout() {
        return about;
    }

    public void setAbout(String about) {
        this.about = about;
    }
}
