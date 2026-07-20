package com.moetaz.librarymanagement.dto;

import java.util.Objects;

public class CreateBookRequest {

    private String title;
    private Integer authorId;

    public CreateBookRequest() {
    }

    public CreateBookRequest(String title, Integer authorId) {
        this.title = title;
        this.authorId = authorId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getAuthorId() {
        return authorId;
    }

    public void setAuthorId(Integer authorId) {
        this.authorId = authorId;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        CreateBookRequest that = (CreateBookRequest) o;
        return Objects.equals(title, that.title) && Objects.equals(authorId, that.authorId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, authorId);
    }
}

