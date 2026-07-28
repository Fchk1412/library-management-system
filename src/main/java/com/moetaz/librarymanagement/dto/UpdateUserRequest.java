package com.moetaz.librarymanagement.dto;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;


import java.util.Objects;

public class UpdateUserRequest {
    @NotBlank
    private String name;
    @NotBlank
    @Email
    private String email;

    public UpdateUserRequest(String name, String email) {
        this.name = name;
        this.email = email;
    }

    public UpdateUserRequest() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        UpdateUserRequest that = (UpdateUserRequest) o;
        return Objects.equals(name, that.name) && Objects.equals(email, that.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, email);
    }
}


