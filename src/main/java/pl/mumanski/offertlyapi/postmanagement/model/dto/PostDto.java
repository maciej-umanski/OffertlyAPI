package pl.mumanski.offertlyapi.postmanagement.model.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import pl.mumanski.offertlyapi.categorymanagement.model.dto.CategoryDto;

import java.time.OffsetDateTime;
import java.util.List;

@Data
@Schema
public class PostDto {
    private Long id;
    private String title;
    private OffsetDateTime created;
    private String city;
    private Double price;
    private String currency;
    private String photoUrl;
    private Integer reportCount;
    private List<CategoryDto> categories;
    private AuthorDto author;
}
