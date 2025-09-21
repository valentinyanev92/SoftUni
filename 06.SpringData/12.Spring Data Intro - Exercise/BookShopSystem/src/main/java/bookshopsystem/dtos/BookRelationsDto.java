package bookshopsystem.dtos;

import bookshopsystem.entities.Author;
import bookshopsystem.entities.Category;

import java.util.Set;

public class BookRelationsDto {
    private final Author author;
    private final Set<Category> categories;

    public BookRelationsDto(Author author, Set<Category> categories) {
        this.author = author;
        this.categories = categories;
    }

    public Author getAuthor() {
        return author;
    }

    public Set<Category> getCategories() {
        return categories;
    }
}
