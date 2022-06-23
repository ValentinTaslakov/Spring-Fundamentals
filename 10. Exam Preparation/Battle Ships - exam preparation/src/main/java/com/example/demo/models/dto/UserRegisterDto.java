package com.example.demo.models.dto;

import com.example.demo.models.validation.MatchPassword;
import com.example.demo.models.validation.UniqueUserEmail;
import com.example.demo.models.validation.UniqueUsername;
import org.hibernate.validator.constraints.UniqueElements;

import javax.persistence.UniqueConstraint;
import javax.validation.constraints.*;

@MatchPassword(
        first = "password",
        second = "confirmPassword",
        message = "Password do not match."
)
public class UserRegisterDto {

    @NotBlank(message = "Username is required")
    @Size(min = 3, max = 10)
    @UniqueUsername
    private String username;

    @NotBlank
    @Size(min = 5, max = 20)
    private String fullName;

    @Email(regexp = "@",message = "User email should be valid.")
    @UniqueUserEmail(message = "User email should be unique.")
    @NotBlank(message = "Email is required.")
    private String email;

    @Size(min = 3)
    @NotBlank
    private String password;


    private String confirmPassword;

    public String getUsername() {
        return username;
    }

    public UserRegisterDto setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getFullName() {
        return fullName;
    }

    public UserRegisterDto setFullName(String fullName) {
        this.fullName = fullName;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public UserRegisterDto setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public UserRegisterDto setPassword(String password) {
        this.password = password;
        return this;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public UserRegisterDto setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
        return this;
    }
}
