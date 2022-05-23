package pl.mumanski.offertlyapi.model.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import javax.persistence.*;
import java.time.OffsetDateTime;

@Data
@Schema
public class CommentDto {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String comment;
    private OffsetDateTime created;
    private Double rate;
    private Long authorId;
}
