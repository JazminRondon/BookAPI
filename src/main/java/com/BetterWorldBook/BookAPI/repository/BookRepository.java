package com.BetterWorldBook.BookAPI.repository;

import com.BetterWorldBook.BookAPI.model.Books;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends CrudRepository<Books,Long> {
    @Query( value = "SELECT b FROM Books b WHERE " + "b.name LIKE CONCAT('%',:query, '%')")
    Iterable<Books> searchBooks(String query);

    Iterable<Books> findByCategoryId(Long categoryId);

}
