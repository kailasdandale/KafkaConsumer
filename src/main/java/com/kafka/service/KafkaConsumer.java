package com.kafka.service;

import com.kafka.model.Book;
import com.kafka.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.annotation.PartitionOffset;
import org.springframework.kafka.annotation.TopicPartition;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumer {
    @Autowired
    private BookRepository bookRepository;


    @KafkaListener(
            topicPartitions = @TopicPartition(
                    topic = "kafkaTopic",
                    partitionOffsets = @PartitionOffset(
                            partition = "0",
                            initialOffset = "0"
                    )
            ),
            groupId = "test_group1"
    )
    public void listenToKafkaTopic(Book book) {

        bookRepository.save(book);
        System.out.println("Message received in Consumer2 : " + book);
    }


}
