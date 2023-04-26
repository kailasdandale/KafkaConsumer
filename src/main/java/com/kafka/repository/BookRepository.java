package com.kafka.repository;

import com.kafka.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
public interface BookRepository extends JpaRepository<Book, Integer> {


}
