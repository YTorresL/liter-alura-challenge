package com.torres.liter_alura_challenge.model;

import jakarta.persistence.*;

@Entity
@Table(name = "books")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    private String title;
    private String lenguages;
    private Integer downloadCount;

    @ManyToOne
    private Author author;

    public Book(BookData bookData) {
        this.title = bookData.title();
        this.lenguages = bookData.languages().toString();
        this.downloadCount = bookData.downloadCount();
        this.author = bookData.authors().stream().findFirst().map(Author::new).orElse(null);
    }

}
