package pl.mumanski.offertlyapi.postmanagement.model.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.util.List;

@Data
@Schema
public class CreatePostDto {
    private String title;
    private String city;
    private Double price;
    private String currency;
    private String photoUrl;
    private List<Long> categories;
    private Long authorId;
}
