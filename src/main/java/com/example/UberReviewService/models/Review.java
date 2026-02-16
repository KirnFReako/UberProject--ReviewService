package com.example.UberReviewService.models;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.util.Date;

@Getter
@Setter
@Builder
@Entity

@NoArgsConstructor
@AllArgsConstructor
@Table(name = "bookingreview")
public class Review extends BaseModel{

// better segregation using base model
  //srp

  private String content;

  private Double rating;



  @Override
  public String toString() {
    return "Review [content=" + this.content + ", rating=" + this.rating + ", createdAt=" + this.createdAt
        + ", updatedAt=" + this.updatedAt + "]";
  }

}
