package com.torres.liter_alura_challenge.model;

import jakarta.persistence.*;

@Entity
@Table(name = "books")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

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

    public String getLanguages() {
        return languages;
    }

    public void setLanguages(String languages) {
        this.languages = languages;
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

    @Column(unique = true)
    private String title;
    private String languages;
    private Integer downloadCount;

    @ManyToOne
    private Author author;

    public Book() {
    }

    public Book(BookData bookData) {
        this.title = bookData.title();
        this.languages = String.join(", ", bookData.languages());
        this.downloadCount = bookData.downloadCount();
        this.author = bookData.authors().stream().findFirst().map(Author::new).orElse(null);
    }

    public void setAuthor(Author authorDB) {
        this.author = authorDB;
    }

    @Override
    public String toString() {
        return '\n' + "Title= " + title + '\n' +
                "Languages= " + languages + '\n' +
                "DownloadCount= " + downloadCount + '\n' +
                "Author= " + author.getName() + '\n';
    }

    public void addAuthor(Author author) {
        author.getBooks().add(this);
    }
}
