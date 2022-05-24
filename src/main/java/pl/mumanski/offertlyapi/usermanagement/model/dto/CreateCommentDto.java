package pl.mumanski.offertlyapi.usermanagement.model.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@Schema
public class CreateCommentDto {
    private String comment;
    private Double rate;
    private Long authorId;
}
