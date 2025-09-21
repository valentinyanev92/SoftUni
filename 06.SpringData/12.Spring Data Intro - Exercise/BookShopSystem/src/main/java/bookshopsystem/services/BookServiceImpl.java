package bookshopsystem.services;

import bookshopsystem.dtos.BookInputDto;
import bookshopsystem.dtos.BookRelationsDto;
import bookshopsystem.entities.Book;
import bookshopsystem.repositories.AuthorRepository;
import bookshopsystem.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class BookServiceImpl implements BookService {
    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;

    @Autowired
    public BookServiceImpl(BookRepository bookRepository, AuthorRepository authorRepository) {
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
    }

    @Override
    public Book create(BookInputDto inputDto, BookRelationsDto bookRelationsDto) {
        Book book = new Book();

        book.setTitle(inputDto.getTitle());
        book.setCopies(inputDto.getCopies());
        book.setPrice(inputDto.getPrice());
        book.setReleaseDate(inputDto.getReleaseDate());
        book.setEditionType(inputDto.getEditionType());
        book.setAgeRestriction(inputDto.getAgeRestriction());

        book.setAuthor(bookRelationsDto.getAuthor());
        book.setCategories(bookRelationsDto.getCategories());

        return bookRepository.save(book);
    }

    @Override
    public List<Book> findBooksReleasedAfter(int year) {
        LocalDate date = LocalDate.of(year, 1, 1);

        return bookRepository.findAllByReleaseDateAfter(date);
    }

    @Override
    public List<Book> findAllByAuthor(String firstName, String lastName) {
        return bookRepository.findAllByAuthorFistNameAndAuthorLastNameOrderByReleaseDateDescTitleAsc(firstName, lastName);
    }
}
