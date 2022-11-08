package com.BetterWorldBook.BookAPI.controllers;

import com.BetterWorldBook.BookAPI.model.Books;
import com.BetterWorldBook.BookAPI.service.BooksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.awt.print.Book;

@RestController
public class BookController {

    @Autowired
    private BooksService bookService;



    @PostMapping("/books/{categoryId}/books")            //Valid
    public void createBook(@PathVariable (value = "categoryId") Long categoryId,@Valid @RequestBody Books book) {
        bookService.createBook(book,categoryId);
    }

    @GetMapping("/books")
    public ResponseEntity<Iterable<Books>> getAllBooks(){
        return bookService.getAllBooks();
    }

    @GetMapping("books/{bookId}")
    public ResponseEntity<?> getBookId(@PathVariable long bookId) {
        return bookService.getBookById(bookId);
    }

    @PutMapping("/books/{categoryId}/books")            //Valid
    public void updateBook(@PathVariable (value = "categoryId") Long categoryId,@Valid @RequestBody Books book) {
        bookService.createBook(book,categoryId);
    }

    @DeleteMapping("/books/{Id}")
    public void deleteBook(@PathVariable Long Id) {
        bookService.deleteBook(Id);
    }

    @GetMapping("/books/{categoryId}/books")
    public Iterable<Books> findCategoryById(@PathVariable Long categoryId){
        return bookService.findCategoryById(categoryId);
    }


    @GetMapping("/searchbooks")
    public Iterable<Books> searchBooks(@RequestParam("query") String query){
        return bookService.searchBooks(query);
    }



}
