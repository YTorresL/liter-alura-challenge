package com.torres.liter_alura_challenge.repository;

import com.torres.liter_alura_challenge.model.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<Author, Long> {
}
