package bookshopsystem.repositories;

import bookshopsystem.dtos.AuthorSummaryDto;
import bookshopsystem.entities.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Long> {

    List<Author> findDistinctByBooksReleaseDateLessThan(LocalDate releaseDate);

//    @Query("select a from Author as a join a.books order by size(a.books) desc")
//    List<Author> findAllOrderByBooksDesc();

    @Query("select a.fistName, a.lastName, size(a.books) from Author as a order by size(a.books) desc")
    List<AuthorSummaryDto> getSummary();

    Author findByFistNameAndLastName(String fistName, String lastName);
}
