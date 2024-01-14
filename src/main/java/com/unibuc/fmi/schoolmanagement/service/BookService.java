package com.unibuc.fmi.schoolmanagement.service;

import com.unibuc.fmi.schoolmanagement.dto.BookDto;
import com.unibuc.fmi.schoolmanagement.mapper.BookMapper;
import com.unibuc.fmi.schoolmanagement.model.Book;
import com.unibuc.fmi.schoolmanagement.model.Student;
import com.unibuc.fmi.schoolmanagement.repository.BookRepository;
import com.unibuc.fmi.schoolmanagement.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {
    private final BookRepository bookRepository;
    private final BookMapper bookMapper;
    private final StudentRepository studentRepository;

    @Autowired
    public BookService(BookRepository bookRepository, BookMapper bookMapper, StudentRepository studentRepository) {
        this.bookRepository = bookRepository;
        this.bookMapper = bookMapper;
        this.studentRepository = studentRepository;
    }

    public List<Book> getBooks() {
        return bookRepository.findAll();
    }

    public int addBook(BookDto bookDto){
        Book book = bookMapper.mapBookDtoToBook(bookDto);
        return bookRepository.save(book).getId();
    }

    public void deleteBookById(int id) {
        boolean exists = bookRepository.existsById(id);
        if(!exists){
            throw new IllegalStateException("book with "+ id +" doesn't exist");
        }
        bookRepository.deleteById(id);
    }

    public int updateBook(BookDto bookDto) {
        boolean exists = bookRepository.existsById(bookDto.getId());
        if(!exists){
            throw new IllegalStateException("book with "+ bookDto.getId() +" doesn't exist");
        }
        Book newBook = bookMapper.mapBookDtoToBook(bookDto);
        return bookRepository.save(newBook).getId();
    }

    public int borrowBook(int bookId, int studentId) {
        boolean exists = studentRepository.existsById(studentId);
        if(!exists){
            throw new IllegalStateException("student with "+ studentId +" doesn't exist");
        }
        Book bookToBeBorrow = bookRepository.findById(bookId).get();
        Student student = studentRepository.findById(studentId).get();
        bookToBeBorrow.setStudent(student);
        bookToBeBorrow.setAvailable(false);
        return bookRepository.save(bookToBeBorrow).getId();
    }
}
