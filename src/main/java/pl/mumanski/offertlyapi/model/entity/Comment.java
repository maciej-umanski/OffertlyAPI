package pl.mumanski.offertlyapi.model.entity;

import lombok.Data;

import javax.persistence.*;
import java.time.OffsetDateTime;

@Entity
@Table(name = "comments")
@Data
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String comment;
    private OffsetDateTime created;
    private Double rate;
    private Long authorId;
}
