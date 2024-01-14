package com.unibuc.fmi.schoolmanagement.mapper;

import com.unibuc.fmi.schoolmanagement.dto.BookDto;
import com.unibuc.fmi.schoolmanagement.model.Book;
import org.springframework.stereotype.Component;

@Component
public class BookMapper {
    public Book mapBookDtoToBook(BookDto bookDto){
        return Book.builder()
                .id(bookDto.getId())
                .author(bookDto.getAuthor())
                .name(bookDto.getName())
                .available(bookDto.isAvailable())
                .build();
    }
}
