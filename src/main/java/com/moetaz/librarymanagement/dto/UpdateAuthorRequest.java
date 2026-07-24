package com.moetaz.librarymanagement.dto;

import jakarta.validation.constraints.NotBlank;

import java.util.Objects;

public class UpdateAuthorRequest {

    @NotBlank
    private String name;
    @NotBlank
    private String nationality;

    public UpdateAuthorRequest() {
    }

    public UpdateAuthorRequest(String name, String nationality) {
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
        UpdateAuthorRequest that = (UpdateAuthorRequest) o;
        return Objects.equals(name, that.name) && Objects.equals(nationality, that.nationality);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, nationality);
    }
}
