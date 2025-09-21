package com.example.springintro.repository;

import com.example.springintro.model.entity.Author;
import com.example.springintro.model.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Long> {

    @Query("SELECT a FROM Author a ORDER BY size(a.books) DESC")
    List<Author> findAllByBooksSizeDESC();

    List<Author> findAllByFirstNameEndsWith(String firstNameEndsWith);

    @Query("select sum(b.copies) from Author as a left join Book as b on a.id=b.author.id where a.firstName = :firstName and a.lastName = :lastName")
    int countAllCopiesByFirstNameAndLastName(String firstName, String lastName);
}
