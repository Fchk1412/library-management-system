package com.moetaz.librarymanagement.dto;

import java.util.Objects;

public class AuthorDto {

    private Integer id;
    private String name;
    private String nationality;

    public AuthorDto() {
    }

    public AuthorDto(Integer id, String name, String nationality) {
        this.id = id;
        this.name = name;
        this.nationality = nationality;
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

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        AuthorDto authorDto = (AuthorDto) o;
        return Objects.equals(id, authorDto.id) && Objects.equals(name, authorDto.name) && Objects.equals(nationality, authorDto.nationality);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, nationality);
    }
}
