package com.alejoqm.service;

import org.apache.kafka.clients.consumer.ConsumerRecord;

public interface BookService {
  void processBook(ConsumerRecord consumerRecord);
}
