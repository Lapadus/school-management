package com.unibuc.fmi.schoolmanagement.controller;

import com.unibuc.fmi.schoolmanagement.dto.BookDto;
import com.unibuc.fmi.schoolmanagement.dto.BorrowBook;
import com.unibuc.fmi.schoolmanagement.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/books")
public class BookController {
    private final BookService bookService;

    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping
    public ResponseEntity<?> getBooks() {return new ResponseEntity<>(bookService.getBooks(), HttpStatus.OK);}

    @PostMapping("/addBook")
    public  ResponseEntity<?> addBook(@RequestBody BookDto bookDto) { return new ResponseEntity<>(bookService.addBook(bookDto), HttpStatus.OK);}

    @DeleteMapping("/deleteBook/{id}")
    public ResponseEntity<?> delete(@PathVariable int id){ bookService.deleteBookById(id); return new ResponseEntity<>(HttpStatus.OK); }

    @PutMapping("/updateBook")
    public  ResponseEntity<?> updateBook(@RequestBody BookDto bookDto) { return new ResponseEntity<>(bookService.updateBook(bookDto), HttpStatus.OK);}

    @PutMapping("/borrowBook")
    public  ResponseEntity<?> updateBook(@RequestBody BorrowBook borrowBook) { return new ResponseEntity<>(bookService.borrowBook(borrowBook.getBookId(), borrowBook.getStudentId()), HttpStatus.OK);}
}
