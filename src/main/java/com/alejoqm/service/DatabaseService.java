package com.alejoqm.service;

import com.alejoqm.domain.LibraryEvent;
import org.apache.kafka.clients.consumer.ConsumerRecord;

public interface DatabaseService {

  void processBook(LibraryEvent libraryEvent, ConsumerRecord consumerRecord);
}
