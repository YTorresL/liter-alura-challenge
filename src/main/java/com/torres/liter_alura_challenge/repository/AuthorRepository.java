package com.torres.liter_alura_challenge.repository;

import com.torres.liter_alura_challenge.model.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AuthorRepository extends JpaRepository<Author, Long> {
    @Query("select a from Author a where a.birthYear <=:option and a.deathYear >=:option")
    List<Author> findByBirthYear(int option);

    Author findByName(String author);
}
