package com.example.springintro.repository;

import com.example.springintro.model.entity.AgeRestriction;
import com.example.springintro.model.entity.Book;
import com.example.springintro.model.entity.EditionType;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

    List<Book> findAllByReleaseDateAfter(LocalDate releaseDateAfter);

    List<Book> findAllByAuthor_FirstNameAndAuthor_LastNameOrderByReleaseDateDescTitle(String author_firstName, String author_lastName);

    List<Book> findAllByAgeRestriction(AgeRestriction ageRestriction);

    List<Book> findAllByCopiesLessThanAndEditionType(Integer copiesIsLessThan, EditionType editionType);
    List<Book> findAllByPriceLessThanOrPriceGreaterThan(BigDecimal priceIsLessThan, BigDecimal priceIsGreaterThan);
    List<Book> findAllByReleaseDateIsNot(LocalDate releaseDateNotAfter);
    List<Book> findAllByReleaseDateBefore(LocalDate releaseDateBefore);
    List<Book> findAllByTitleContainsIgnoreCase(String title);
    List<Book> findAllByAuthorLastNameStartsWithIgnoreCase(String authorLastName);

    @Query("select count(b.id) from Book as b where length(b.title) > :greaterThan")
    int findAllByTitleGreaterThan(int greaterThan);

//    @Query("select b.title, b.editionType, b.ageRestriction, b.price from Book as b where b.title=:title")
    Book findBookByTitle(String title);

    @Modifying
    @Transactional
    @Query("update Book as b set b.copies = b.copies + :increase where b.title = :title")
    void updateBookCopiesAfterDate(String title, long increase);


}
