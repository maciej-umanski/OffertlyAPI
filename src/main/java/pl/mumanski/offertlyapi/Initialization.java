package pl.mumanski.offertlyapi;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import pl.mumanski.offertlyapi.categorymanagement.CategoryService;
import pl.mumanski.offertlyapi.categorymanagement.model.dto.CreateCategoryDto;

import javax.annotation.PostConstruct;
import java.util.Map;

@Component
@AllArgsConstructor
public class Initialization {

    private final static Map<String, String> CATEGORIES = Map.of(
            "hydraulika", "hydraulics",
            "elektryka", "electrician",
            "malarz", "painter",
            "złota rączka", "handyman",
            "naprawy", "repairs",
            "mechanik", "mechanic");
    private final CategoryService categoryService;

    @PostConstruct
    public void init() {
        if (categoryService.getAllCategories().isEmpty()) {
            CATEGORIES.forEach((key, value) -> categoryService.create(CreateCategoryDto.of(key, value)));
        }
    }
}
