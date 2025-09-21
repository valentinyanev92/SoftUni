package com.example.springintro;

import com.example.springintro.model.entity.AgeRestriction;
import com.example.springintro.model.entity.Book;
import com.example.springintro.model.entity.EditionType;
import com.example.springintro.service.AuthorService;
import com.example.springintro.service.BookService;
import com.example.springintro.service.CategoryService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.math.BigDecimal;
import java.sql.SQLOutput;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

@Component
public class CommandLineRunnerImpl implements CommandLineRunner {

    private final CategoryService categoryService;
    private final AuthorService authorService;
    private final BookService bookService;
    private final Scanner scanner = new Scanner(System.in);

    public CommandLineRunnerImpl(CategoryService categoryService, AuthorService authorService, BookService bookService) {
        this.categoryService = categoryService;
        this.authorService = authorService;
        this.bookService = bookService;
    }

    @Override
    public void run(String... args) throws Exception {
        seedData();

        //printAllBooksAfterYear(2000);
//        printAllAuthorsNamesWithBooksWithReleaseDateBeforeYear(1990);
        //   printAllAuthorsAndNumberOfTheirBooks();
//        pritnALlBooksByAuthorNameOrderByReleaseDate("George", "Powell");

        //01.
//        printAllBooksByCategory();
        //02.
//        printAllGoldenBooks();
        //03.
//        printAllBooksByPriceLowerAndUpper();
        //04.
//        printAllBooksNotReleasedInYear();
        //05.
//        printAllBooksReleasedBefore();
        //06.
//        printAllBooksByAuthorFistNameEnd();
        //07.
//        printAllBooksThatContainsInName();
        //08.
//        printAllBooksByAuthorNameStartWith();
        //09.
//        printCountBooksWithNameLongerThan();
        //10.
//        printAllCopies();
        //11.
//        printInfoForBook();
        //12.
        updateBookCopiesAfterDate();

    }

    private void updateBookCopiesAfterDate() {
        System.out.print("Enter the date: ");
        String[] date = scanner.nextLine().split("\\s+");
        int day = Integer.parseInt(date[0]);
        int month = Integer.parseInt(date[1]);
        int year = Integer.parseInt(date[2]);

        System.out.print("Enter the number of copies to increase: ");
        long copies = Integer.parseInt(scanner.nextLine());

        LocalDate localDate = LocalDate.of(year, month, day);
        List<Book> allByReleaseDateAfter = bookService.findAllByReleaseDateAfter(localDate);

        int i = 0;
        for (Book book : allByReleaseDateAfter) {
            bookService.updateBookCopiesAfterDate(book.getTitle(), copies);
            i++;
        }
        System.out.println(i*copies);
    }

    private void printInfoForBook() {
        System.out.print("Enter title: ");
        String title = scanner.nextLine();
        Book book = bookService.selectBookByTitle(title);
        System.out.printf("%s %s %s %s%n", book.getTitle(), book.getEditionType(), book.getAgeRestriction(), book.getPrice());
    }

    private void printAllCopies() {
        String name = "Randy Graham";
        int count = authorService.countCopies();
        System.out.printf("%s - %s%n", name, count);
    }

    private void printCountBooksWithNameLongerThan() {
        System.out.print("Enter the length of the book name: ");
        int length = scanner.nextInt();
        int i = bookService.countBooksByTitleLength(length);
        System.out.println(i);
    }

    private void printAllBooksByAuthorNameStartWith() {
        System.out.print("Enter the author's last name starting with: ");
        String authorLastNameStartWith = scanner.nextLine();
        List<Book> books = bookService.finaAllByAuthorLastNameStartsWith(authorLastNameStartWith);
        for (Book book : books) {
            System.out.printf("%s(%s %s)%n", book.getTitle(), book.getAuthor().getFirstName(), book.getAuthor().getLastName());
        }
    }

    private void printAllBooksThatContainsInName() {
        System.out.print("Enter the name containing the books: ");
        String bookName = scanner.nextLine();
        List<Book> allByTitleContains = bookService.findAllByTitleContains(bookName);
        for (Book book : allByTitleContains) {
            System.out.println(book.getTitle());
        }
    }

    private void printAllBooksByAuthorFistNameEnd() {
        System.out.print("Enter name ending: ");
        String ending = scanner.nextLine();

        authorService.getAuthorByNameEndingWith(ending).forEach(s -> {
            System.out.printf("%s %s%n", s.getFirstName(), s.getLastName());
        });
    }

    private void printAllBooksReleasedBefore() {
        System.out.print("Enter the date: ");
        String[] input = scanner.nextLine().split("-");
        String day = input[0];
        String month = input[1];
        String year = input[2];
        LocalDate releaseDate = LocalDate.parse(year + "-" + month + "-" + day);
        List<Book> allByReleaseDateBefore = bookService.findAllByReleaseDateBefore(releaseDate);
        for (Book book : allByReleaseDateBefore) {
            System.out.printf("%s %s %s%n", book.getTitle(), book.getEditionType(), book.getPrice());
        }

    }

    private void printAllBooksNotReleasedInYear() {
        System.out.print("Enter the year: ");
        int year = Integer.parseInt(scanner.nextLine());
        LocalDate date = LocalDate.of(year, 1, 1);
        List<Book> allByReleaseDateIsNot = bookService.findAllByReleaseDateIsNot(date);
        for (Book book : allByReleaseDateIsNot) {
            System.out.println(book.getTitle());
        }
    }

    private void printAllBooksByPriceLowerAndUpper() {
        List<Book> allByPriceLessThanAndPriceGreaterThan = bookService.findAllByPriceLessThanAndPriceGreaterThan(BigDecimal.valueOf(5), BigDecimal.valueOf(40));
        for (Book book : allByPriceLessThanAndPriceGreaterThan) {
            System.out.printf("%s - $%s%n", book.getTitle(), book.getPrice());
        }
    }

    private void printAllGoldenBooks() {
        EditionType editionType = EditionType.valueOf("GOLD");
        List<Book> allByCopiesLessThan = bookService.findAllByCopiesLessThan(5000, editionType);
        for (Book book : allByCopiesLessThan) {
            System.out.println(book.getTitle());
        }
    }

    private void printAllBooksByCategory() {
        System.out.print("Enter the category: ");
        String input = scanner.nextLine().toUpperCase();
        AgeRestriction restriction = AgeRestriction.valueOf(input);

        List<Book> allByAgeRestriction = bookService.findAllByAgeRestriction(restriction);
        for (Book book : allByAgeRestriction) {
            System.out.println(book.getTitle());
        }
    }

    private void pritnALlBooksByAuthorNameOrderByReleaseDate(String firstName, String lastName) {
        bookService
                .findAllBooksByAuthorFirstAndLastNameOrderByReleaseDate(firstName, lastName)
                .forEach(System.out::println);
    }

    private void printAllAuthorsAndNumberOfTheirBooks() {
        authorService
                .getAllAuthorsOrderByCountOfTheirBooks()
                .forEach(System.out::println);
    }

    private void printAllAuthorsNamesWithBooksWithReleaseDateBeforeYear(int year) {
        bookService
                .findAllAuthorsWithBooksWithReleaseDateBeforeYear(year)
                .forEach(System.out::println);
    }

    private void printAllBooksAfterYear(int year) {
        bookService
                .findAllBooksAfterYear(year)
                .stream()
                .map(Book::getTitle)
                .forEach(System.out::println);
    }

    private void seedData() throws IOException {
        categoryService.seedCategories();
        authorService.seedAuthors();
        bookService.seedBooks();
    }
}
