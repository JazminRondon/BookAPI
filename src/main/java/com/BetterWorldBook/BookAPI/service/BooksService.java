package com.BetterWorldBook.BookAPI.service;

import com.BetterWorldBook.BookAPI.model.Books;
import com.BetterWorldBook.BookAPI.model.Category;
import com.BetterWorldBook.BookAPI.repository.BookRepository;
import com.BetterWorldBook.BookAPI.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.Optional;

@Service
public class BooksService {

    @Autowired
    BookRepository booksRepository;

    @Autowired
    CategoryRepository categoryRepository;


    public void createBook(Books book, Long categoryId) {
        categoryRepository.findById(categoryId).map(category -> {
            book.setCategory(category);
            return booksRepository.save(book);

        });


    }


    public ResponseEntity<Iterable<Books>> getAllBooks(){
        Iterable<Books> allBooks= booksRepository.findAll();
        return new ResponseEntity<>(allBooks, HttpStatus.OK);
    }

    public ResponseEntity<?> getBookById(Long bookId) {
        Optional<Books> books = booksRepository.findById(bookId);
        return new ResponseEntity<>(books, HttpStatus.OK);
    }

    public void updateBook(Books book, Long categoryId) {
        categoryRepository.findById(categoryId).map(category -> {
            book.setCategory(category);
            return booksRepository.save(book);

        });
    }

    public void deleteBook(Long bookId) {
        booksRepository.deleteById(bookId);
    }

    public Iterable<Books> findCategoryById(Long categoryId){
        return booksRepository.findByCategoryId(categoryId);
    }

    public Iterable<Books> searchBooks(String query){
        return booksRepository.searchBooks(query);
    }


}
