package com.example.UberReviewService.models;

import jakarta.persistence.*;
import org.hibernate.annotations.TargetEmbeddable;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;

import java.util.Date;

@Entity
@Table(name = "bookingreview")
public class Review {

    @Id // this annotation makes the id property key of our table
    @GeneratedValue(strategy = GenerationType.IDENTITY)
            // identity means auto increment
    long id;

    @Column(nullable = false)
    String Content;

    Double rating;

    @Column(nullable = false)
     @Temporal(TemporalType.TIMESTAMP) // this annotation tells spring about the format of Date object to be stored i.e. started date ? time Timestamp
     @CreatedDate // this annotation tells spring that only handle it for object creation
    Date createdAt;

    @Column(nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @LastModifiedBy // this annotation tells spring that only handle it for object update
    Date updatedAt;


}
