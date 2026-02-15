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
@EntityListeners(AuditingEntityListener.class)
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "bookingreview")
public class Review {

  @Id // this annotation makes the id property key of our table
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  // identity means auto increment
  private long id;

  private String content;

  private Double rating;

  @Temporal(TemporalType.TIMESTAMP) // this annotation tells spring about the format of Date object to be stored
                                    // i.e. started date ? time Timestamp
  @CreatedDate // this annotation tells spring that only handle it for object creation
  private Date createdAt;

  @Temporal(TemporalType.TIMESTAMP)
  @LastModifiedDate // this annotation tells spring that only handle it for object update
  private Date updatedAt;

  @Override
  public String toString() {
    return "Review [content=" + this.content + ", rating=" + this.rating + ", createdAt=" + this.createdAt
        + ", updatedAt=" + this.updatedAt + "]";
  }

}
