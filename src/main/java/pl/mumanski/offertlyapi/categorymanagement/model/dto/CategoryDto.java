package pl.mumanski.offertlyapi.categorymanagement.model.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@Schema
public class CategoryDto {
    private Long id;
    private String namePl;
    private String nameEng;
}
