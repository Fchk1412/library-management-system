package com.moetaz.librarymanagement.dto;

import jakarta.validation.constraints.NotBlank;

import java.util.Objects;

public class CreateAuthorRequest {

    @NotBlank
    private String name;
    @NotBlank
    private String nationality;

    public CreateAuthorRequest() {
    }

    public CreateAuthorRequest(String name, String nationality) {
        this.name = name;
        this.nationality = nationality;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        CreateAuthorRequest that = (CreateAuthorRequest) o;
        return Objects.equals(name, that.name) && Objects.equals(nationality, that.nationality);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, nationality);
    }
}
