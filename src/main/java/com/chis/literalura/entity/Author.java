package com.chis.literalura.entity;

import com.chis.literalura.dto.AuthorRequest;
import jakarta.persistence.*;

import java.util.List;
import java.util.stream.Collectors;

@Entity
public class Author {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private Integer birthYear;
    private Integer deathYear;

    @OneToMany(mappedBy = "author", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Book> books;

    public Author(AuthorRequest request) {
        this.name = request.name();
        this.birthYear = request.birthYear();
        this.deathYear = request.deathYear();
    }

    public Author() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getBirthYear() {
        return birthYear;
    }

    public void setBirthYear(Integer birthYear) {
        this.birthYear = birthYear;
    }

    public Integer getDeathYear() {
        return deathYear;
    }

    public void setDeathYear(Integer deathYear) {
        this.deathYear = deathYear;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    @Override
    public String toString() {
        return "---------- AUTHOR ----------\n" +
                "Author: " + this.name + "\n" +
                "Birth Year: " + this.birthYear + "\n" +
                "Death Year: " + this.deathYear + "\n" +
                "Books: " + this.books.stream().map(Book::getTitle).toList() + "\n" +
                "----------------------------\n";
    }
}
