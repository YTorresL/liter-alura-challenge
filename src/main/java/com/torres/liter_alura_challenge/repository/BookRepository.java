package com.torres.liter_alura_challenge.repository;

import com.torres.liter_alura_challenge.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, Long> {
    List<Book> findByLanguages(String language);
}
