package pl.mumanski.offertlyapi.usermanagement.model.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.time.OffsetDateTime;

@Data
@Schema
public class CommentDto {
    private Long id;
    private String comment;
    private OffsetDateTime created;
    private Double rate;
    private Long authorId;
}
