package bookshopsystem.repositories;

import bookshopsystem.entities.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
    List<Book> findAllByReleaseDateAfter(LocalDate releaseDate);

    @Query("select b from Book as b join Author as a on a.id = b.author.id where a.fistName='George' and a.lastName='Powell' order by b.releaseDate desc, b.title asc")
    List<Book> findAllByAuthor(String firstName, String lastName);

    List<Book> findAllByAuthorFistNameAndAuthorLastNameOrderByReleaseDateDescTitleAsc(String firstName, String lastName);
}
