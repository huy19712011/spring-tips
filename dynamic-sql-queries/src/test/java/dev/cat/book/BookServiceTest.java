package dev.cat.book;

import dev.cat.book.model.Book;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;


@SpringBootTest
class BookServiceTest {

    @Autowired
    BookService bookService;

    @Test
    void findAllBookByCategory() {
        List<Book> books = bookService.findAllFiltered(
                "Nonfiction", null, null, 0);
        int expected = 2;
        Assertions.assertEquals(expected, books.size());
    }

    @Test
    void findAllBookByCategoryAndFormat() {
        List<Book> books = bookService.findAllFiltered(
                "Fiction", null, "Hardcover", 0);
        int expected = 7;
        Assertions.assertEquals(expected, books.size());
    }

    @Test
    void findAllBookByCategoryAndLanguage() {
        List<Book> books = bookService.findAllFiltered(
                "Fiction", "German", null, 0);
        int expected = 3;
        Assertions.assertEquals(expected, books.size());
    }


    @Test
    void findAllBookByCategoryAndLanguageAndFormat() {
        List<Book> books = bookService.findAllFiltered(
                "Fiction", "German", "Hardcover", 0);
        int expected = 2;
        Assertions.assertEquals(expected, books.size());
    }

    @Test
    void findAllBookByCategoryAndLanguageAndFormatAndPrice() {
        List<Book> books = bookService.findAllFiltered(
                "Fiction", "German", "Hardcover", 29);
        int expected = 1;
        Assertions.assertEquals(expected, books.size());
    }

    @Test
    void ShouldNotFindAnyIfNoMatches() {
        List<Book> books = bookService.findAllFiltered(
                "Fiction", "German", "Hardcover", 10);
        int expected = 0;
        Assertions.assertEquals(expected, books.size());
    }

    @Test
    void ShouldNotFindAllIfNoFilters() {
        List<Book> books = bookService.findAllFiltered(
                null, null, null, 0);
        int expected = 15;
        Assertions.assertEquals(expected, books.size());
    }


}