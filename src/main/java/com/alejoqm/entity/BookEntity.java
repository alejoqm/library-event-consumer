package com.alejoqm.entity;

import java.sql.Date;
import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
//@Entity(name = "book")
public class BookEntity {

  //@Id
  //@GeneratedValue
  private Integer id;

  //@Column
  private String author;

  //@Column
  private String title;

  //@Column
  private Timestamp createdAt;

  //@Column
  private Date updatedAt;

  //@Column
  private Integer partitionName;

  //@Column
  private String campus;

}
