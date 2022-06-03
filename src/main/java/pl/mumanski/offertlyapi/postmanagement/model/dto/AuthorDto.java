package pl.mumanski.offertlyapi.postmanagement.model.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@Schema
public class AuthorDto {
    private Long id;
    private String name;
    private String lastname;
}
