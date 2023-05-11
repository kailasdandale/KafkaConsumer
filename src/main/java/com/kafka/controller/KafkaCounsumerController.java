package com.kafka.controller;

import com.kafka.model.Book;
import com.kafka.service.BookService;
import com.kafka.service.KafkaConsumer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class KafkaCounsumerController {

    @Autowired
    private BookService bookService;

    @GetMapping
    public List<Book>getBooks(){

        return bookService.getBooks();
    }

}
