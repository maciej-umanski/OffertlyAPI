package pl.mumanski.offertlyapi.postmanagement.model.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import pl.mumanski.offertlyapi.postmanagement.model.enums.Category;

import java.time.OffsetDateTime;

@Data
@Schema
public class CreatePostDto {
    private Long id;
    private String title;
    private OffsetDateTime created;
    private String city;
    private Double price;
    private String currency;
    private String photoUrl;
    private Category category;
}
