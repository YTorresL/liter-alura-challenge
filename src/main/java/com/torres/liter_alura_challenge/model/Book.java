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

    public String getLenguages() {
        return lenguages;
    }

    public void setLenguages(String lenguages) {
        this.lenguages = lenguages;
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
    private String lenguages;
    private Integer downloadCount;

    @ManyToOne
    private Author author;

    public Book() {
    }

    public Book(BookData bookData) {
        this.title = bookData.title();
        this.lenguages = bookData.languages().toString();
        this.downloadCount = bookData.downloadCount();
        this.author = bookData.authors().stream().findFirst().map(Author::new).orElse(null);
    }

    public void setAuthor(Author authorDB) {
        this.author = authorDB;
    }

    @Override
    public String toString() {
        return '\n' + "Title= " + title + '\n' +
                "Lenguages= " + lenguages + '\n' +
                "DownloadCount= " + downloadCount + '\n' +
                "Author= " + author.getName() + '\n';
    }

}
