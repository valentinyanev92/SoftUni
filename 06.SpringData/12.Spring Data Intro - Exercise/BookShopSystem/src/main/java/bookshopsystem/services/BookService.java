package bookshopsystem.services;

import bookshopsystem.dtos.BookInputDto;
import bookshopsystem.dtos.BookRelationsDto;
import bookshopsystem.entities.Book;

import java.util.List;

public interface BookService {
    Book create(BookInputDto inputDto, BookRelationsDto bookRelationsDto);

    List<Book> findBooksReleasedAfter(int year);

    List<Book> findAllByAuthor(String firstName, String lastName);
}
