package pl.mumanski.offertlyapi.categorymanagement.model.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@Schema
@AllArgsConstructor
public class CreateCategoryDto {
    private String namePl;
    private String nameEng;

    public static CreateCategoryDto of(String namePl, String nameEng) {
        return new CreateCategoryDto(namePl, nameEng);
    }
}
