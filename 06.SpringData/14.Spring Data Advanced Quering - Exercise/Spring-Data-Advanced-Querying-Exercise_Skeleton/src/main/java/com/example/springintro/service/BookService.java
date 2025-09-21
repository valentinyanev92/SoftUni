package com.example.springintro.service;

import com.example.springintro.model.entity.AgeRestriction;
import com.example.springintro.model.entity.Book;
import com.example.springintro.model.entity.EditionType;

import java.io.IOException;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

public interface BookService {
    void seedBooks() throws IOException;

    List<Book> findAllBooksAfterYear(int year);

    List<String> findAllAuthorsWithBooksWithReleaseDateBeforeYear(int year);

    List<String> findAllBooksByAuthorFirstAndLastNameOrderByReleaseDate(String firstName, String lastName);

    List<Book> findAllByAgeRestriction(AgeRestriction ageRestriction);
    List<Book> findAllByCopiesLessThan(int copies, EditionType editionType);
    List<Book> findAllByPriceLessThanAndPriceGreaterThan(BigDecimal priceIsLessThan, BigDecimal priceIsGreaterThan);
    List<Book> findAllByReleaseDateIsNot(LocalDate releaseDateNotAfter);
    List<Book> findAllByReleaseDateBefore(LocalDate releaseDateBefore);
    List<Book> findAllByTitleContains(String title);
    List<Book> finaAllByAuthorLastNameStartsWith(String authorLastName);
    int countBooksByTitleLength(int length);
    Book selectBookByTitle(String title);
    void updateBookCopiesAfterDate(String title, long copiesIncrease);
    List<Book> findAllByReleaseDateAfter(LocalDate releaseDateAfter);
}
