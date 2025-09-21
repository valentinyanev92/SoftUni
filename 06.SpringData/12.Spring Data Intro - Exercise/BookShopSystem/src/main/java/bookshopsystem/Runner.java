package bookshopsystem;

import bookshopsystem.dtos.*;
import bookshopsystem.entities.Author;
import bookshopsystem.entities.Book;
import bookshopsystem.entities.Category;
import bookshopsystem.enums.AgeRestriction;
import bookshopsystem.enums.EditionType;
import bookshopsystem.services.AuthorService;
import bookshopsystem.services.BookService;
import bookshopsystem.services.CategoryService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;

@Component
public class Runner implements CommandLineRunner {
    private final CategoryService categoryService;
    private final AuthorService authorService;
    private final BookService bookService;

    public Runner(CategoryService categoryService, AuthorService authorService, BookService bookService) {
        this.categoryService = categoryService;
        this.authorService = authorService;
        this.bookService = bookService;
    }


    @Override
    public void run(String... args) throws Exception {
        List<Category> categories = seedCategories();
        List<Author> authors = seedAuthors();
        seedBooks(authors, categories);

        //01.
        List<Book> books = bookService.findBooksReleasedAfter(2000);
        books.forEach(book -> {
            System.out.println(book.getTitle());
        });

        //02.
        List<Author> authorListBefore1990 = authorService.findAuthorsByReleaseDateBefore(1990);
        for (Author author : authorListBefore1990) {
            System.out.println(author.getFistName() + " " + author.getLastName());
        }

        //03.
        List<AuthorSummaryDto> allByBookQuantity = authorService.getSummary();
        for (AuthorSummaryDto author : allByBookQuantity) {
            System.out.printf("%s %s - %d%n", author.getFirstName(), author.getLastName(), author.getBooksCount());
        }

        //04.
        List<Book> booksByAuthor = bookService.findAllByAuthor("George", "Powell");
        for (Book book : booksByAuthor) {
            System.out.printf("%s (%s) %d%n",book.getTitle(), book.getReleaseDate(), book.getCopies());
        }

    }

    private List<Category> seedCategories() throws IOException {
        List<String> categoriesData = readSeedFile("categories.txt");
        List<Category> categories = new ArrayList<>();
        categoriesData.forEach(s -> {
            CategoryInputDto categoryInputDto = new CategoryInputDto(s);
            Category currentCategory = categoryService.create(categoryInputDto);
            categories.add(currentCategory);
        });
        return categories;
    }

    private List<Author> seedAuthors() throws IOException {
        List<String> authorsData = readSeedFile("authors.txt");
        List<Author> authors = new ArrayList<>();
        authorsData.forEach(author -> {
            AuthorInputDto inputDto = new AuthorInputDto(author);
            Author currentAuthor = authorService.create(inputDto);
            authors.add(currentAuthor);
        });
        return authors;
    }

    private void seedBooks(List<Author> authors, List<Category> categories) throws IOException {
        List<String> booksData = readSeedFile("books.txt");
        for (String line : booksData) {
            String[] data = line.split("\\s+");

            String title = Arrays.stream(data).skip(5).collect(Collectors.joining(" "));
            Long copies = (long) Integer.parseInt(data[2]);
            BigDecimal price = new BigDecimal(data[3]);
            EditionType editionType = EditionType.values()[Integer.parseInt(data[0])];
            LocalDate releaseDate = LocalDate.parse(data[1], DateTimeFormatter.ofPattern("d/M/yyyy"));
            AgeRestriction ageRestriction = AgeRestriction.values()[Integer.parseInt(data[4])];

            int randomAuthorIndex = ThreadLocalRandom.current().nextInt(0, authors.size());
            Author author = authors.get(randomAuthorIndex);

            int randomCategoryCount = ThreadLocalRandom.current().nextInt(0, 3);
            Set<Category> categorySet = new HashSet<>();
            for (int i = 0; i <= randomCategoryCount; i++) {
                int randomCategoryIndex = ThreadLocalRandom.current().nextInt(0, categories.size());
                categorySet.add(categories.get(randomCategoryIndex));
            }

            BookInputDto bookInputDto = new BookInputDto(title, copies, price, editionType, releaseDate, ageRestriction);
            BookRelationsDto bookRelationsDto = new BookRelationsDto(author, categorySet);

            bookService.create(bookInputDto, bookRelationsDto);
        }
    }

    private List<String> readSeedFile(String fileName) throws IOException {
        ClassPathResource resources = new ClassPathResource(fileName);

        try (InputStream inputStream = resources.getInputStream()) {

            InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            return bufferedReader.lines().toList();
        }
    }
}