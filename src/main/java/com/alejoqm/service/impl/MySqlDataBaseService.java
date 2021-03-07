package com.alejoqm.service.impl;

import com.alejoqm.domain.LibraryEvent;
import com.alejoqm.entity.BookEntity;
import com.alejoqm.repository.BookRepository;
import com.alejoqm.service.DatabaseService;
import java.sql.Timestamp;
import java.time.Instant;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class MySqlDataBaseService implements DatabaseService {

  private BookRepository bookRepository;

  @Autowired(required = false)
  public void setBookRepository(BookRepository bookRepository) {
    this.bookRepository = bookRepository;
  }

  @Override
  public void processBook(LibraryEvent libraryEvent, ConsumerRecord consumerRecord) {
    log.info("Saving Book {} in MySql", libraryEvent.getBook().getName());
      bookRepository.save(BookEntity.
          builder().id(libraryEvent.getId()).title(libraryEvent.getBook().getName())
          .author(libraryEvent.getBook().getAuthor())
          .partitionName(consumerRecord.partition())
          .createdAt(Timestamp.from(Instant.now()))
          .campus(libraryEvent.getBook().getCampus())
          .build());
  }
}
