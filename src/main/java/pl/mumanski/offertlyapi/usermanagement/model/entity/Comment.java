package pl.mumanski.offertlyapi.usermanagement.model.entity;

import lombok.Data;

import javax.persistence.*;
import java.time.OffsetDateTime;

@Entity
@Table(name = "comments")
@Data
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String comment;
    private OffsetDateTime created = OffsetDateTime.now();
    private Double rate;
    private Long authorId;
}
