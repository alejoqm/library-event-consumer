package com.alejoqm.consumer;

import com.alejoqm.service.BookService;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.listener.AcknowledgingMessageListener;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class LibraryEventConsumer implements AcknowledgingMessageListener {

  private BookService bookService;

  public LibraryEventConsumer(BookService bookService) {
    this.bookService = bookService;
  }

  @Override
  @KafkaListener(topics = {"${libraryEvent.consumer.topic}"})
  public void onMessage(ConsumerRecord consumerRecord, Acknowledgment acknowledgment) {
    log.info("Message is {} with Acknowledgment", consumerRecord);
    bookService.processBook(consumerRecord);
    acknowledgment.acknowledge();
  }

  @Override
  public void onMessage(Object o) {
    log.info("Message is {} ", o);
  }
}
