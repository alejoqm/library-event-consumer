package com.alejoqm.repository;

import com.alejoqm.domain.LibraryEvent;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoDatabase;
import lombok.extern.slf4j.Slf4j;
import org.bson.Document;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

@Profile("mongodb")
@Slf4j
@Repository
public class MongoDBRepository {

  private MongoDatabase mongoDatabase;
  private ObjectMapper objectMapper;

  public MongoDBRepository() {
    this.objectMapper = new ObjectMapper();
    MongoClient mongoClient = new MongoClient();
    mongoDatabase = mongoClient.getDatabase("library");
  }

  public void saveBook(LibraryEvent libraryEvent) {
      Document document = new Document();
      document.append("name", libraryEvent.getBook().getName());
      document.append("id", libraryEvent.getId());
      document.append("eventType", libraryEvent.getLibraryEventType().name());
      document.append("campus", libraryEvent.getBook().getCampus());
      document.append("author", libraryEvent.getBook().getAuthor());
      mongoDatabase.getCollection("books").insertOne(document);
  }

}
