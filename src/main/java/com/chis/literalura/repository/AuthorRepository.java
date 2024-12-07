package com.chis.literalura.repository;

import com.chis.literalura.entity.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface AuthorRepository extends JpaRepository<Author, Long> {
    Optional<Author> findByName(String name);

    @Query("""
            SELECT author
            FROM Author author
            WHERE :year BETWEEN author.birthYear AND author.deathYear
            """)
    List<Author> findAuthorsAliveInAGivenYear(int year);
}
