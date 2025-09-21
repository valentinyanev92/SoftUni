package bookshopsystem.services;

import bookshopsystem.dtos.AuthorInputDto;
import bookshopsystem.dtos.AuthorSummaryDto;
import bookshopsystem.entities.Author;
import bookshopsystem.repositories.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class AuthorServiceImpl implements AuthorService {
    private final AuthorRepository authorRepository;

    @Autowired
    public AuthorServiceImpl(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @Override
    public Author create(AuthorInputDto inputDto) {
        Author author = new Author();
        author.setFistName(inputDto.getFist_name());
        author.setLastName(inputDto.getLast_name());

        return this.authorRepository.save(author);
    }

    @Override
    public List<Author> findAuthorsByReleaseDateBefore(int year) {
        LocalDate releaseDate = LocalDate.of(year, 1, 1);

        return this.authorRepository.findDistinctByBooksReleaseDateLessThan(releaseDate);
    }

    @Override
    public List<AuthorSummaryDto> getSummary() {
        return this.authorRepository.getSummary();
    }
}