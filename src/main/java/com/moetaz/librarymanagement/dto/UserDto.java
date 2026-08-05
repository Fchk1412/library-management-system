package com.moetaz.librarymanagement.dto;

import com.moetaz.librarymanagement.model.Role;

import java.util.Objects;

public class UserDto {

    private Integer id;
    private String name;
    private String email;
    private Role role;

    public UserDto() {
    }

    public UserDto(Integer id, String name, String email, Role role) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.role = role;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        UserDto userDto = (UserDto) o;
        return Objects.equals(id, userDto.id) && Objects.equals(name, userDto.name) && Objects.equals(email, userDto.email) && role == userDto.role;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, email, role);
    }
}

