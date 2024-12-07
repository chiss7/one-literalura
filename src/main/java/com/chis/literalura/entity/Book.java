package com.chis.literalura.entity;

import com.chis.literalura.dto.BookRequest;
import jakarta.persistence.*;

@Entity
public class Book {
    @Id
    @GeneratedValue
    private Long id;
    private String title;
    private boolean copyright;
    private String language;
    private Integer downloadCount;

    @ManyToOne
    @JoinColumn(name = "author_id", nullable = false)
    private Author author;

    public Book(BookRequest request) {
        this.title = request.title();
        this.language = request.languages().get(0);
        this.downloadCount = request.downloadCount();
        this.copyright = request.copyright();
    }

    public Book() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean isCopyright() {
        return copyright;
    }

    public void setCopyright(boolean copyright) {
        this.copyright = copyright;
    }

    public Integer getDownloadCount() {
        return downloadCount;
    }

    public void setDownloadCount(Integer downloadCount) {
        this.downloadCount = downloadCount;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    @Override
    public String toString() {
        return "---------- BOOK ----------\n" +
                "Title: " + this.title + "\n" +
                "Author: " + this.author.getName() + "\n" +
                "Language: " + this.language + "\n" +
                "Download Count: " + this.downloadCount + "\n" +
                "--------------------------\n";
    }
}
