package dev.cat.book;

import dev.cat.book.model.Book;
import org.springframework.data.jpa.domain.Specification;

public class BookSpecification {

    //category filter

    public static Specification<Book> hasCategoryName(String name) {

        return (root, query, criteriaBuilder) ->
                criteriaBuilder.equal(root
                        .get("category")
                        .get("name"), name);

    }

    //price filter

    public static Specification<Book> hasPriceLessThanOrEqualTo(int price) {

        return (root, query, criteriaBuilder) ->
                criteriaBuilder.lessThanOrEqualTo(root.get("price"), price);

    }

    //language filter

    public static Specification<Book> hasLanguageName(String name) {

        return (root, query, criteriaBuilder) ->
                criteriaBuilder.equal(root
                        .get("language")
                        .get("name"), name);

    }

    //format filter

    public static Specification<Book> hasFormatName(String name) {

        return (root, query, criteriaBuilder) ->
                criteriaBuilder.equal(root
                        .get("format")
                        .get("name"), name);

    }

}
