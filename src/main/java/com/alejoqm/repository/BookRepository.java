package com.alejoqm.repository;

import com.alejoqm.entity.BookEntity;
import org.springframework.context.annotation.Profile;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Profile("mysql")
@Repository
public interface BookRepository extends CrudRepository<BookEntity, Integer> {

}
