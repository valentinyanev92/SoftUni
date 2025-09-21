package bookshopsystem.services;

import bookshopsystem.dtos.AuthorInputDto;
import bookshopsystem.dtos.AuthorSummaryDto;
import bookshopsystem.entities.Author;

import java.util.List;

public interface AuthorService {
    Author create(AuthorInputDto inputDto);

    public List<Author> findAuthorsByReleaseDateBefore(int year);

    public List<AuthorSummaryDto> getSummary();
}
