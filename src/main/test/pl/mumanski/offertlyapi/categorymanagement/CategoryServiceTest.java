package pl.mumanski.offertlyapi.categorymanagement;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import pl.mumanski.offertlyapi.categorymanagement.model.dto.CategoryDto;
import pl.mumanski.offertlyapi.categorymanagement.model.entity.Category;

import java.util.List;
import java.util.Objects;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
class CategoryServiceTest {

    @Autowired
    private CategoryService categoryService;

    @Test
    void create() {
        Category category = Category
                .builder()
                .nameEng("test123")
                .namePl("test321")
                .build();

        category = categoryService.create(CategoryMapper.INSTANCE.toCreateCategoryDto(category));

        assertTrue(Objects.nonNull(category.getId()));
    }

    @Test
    void getAllCategories() {
        List<Category> categories = categoryService.getAllCategories();
        assertFalse(categories.isEmpty());
    }

    @Test
    void getCategory() {
        Category category = categoryService.getCategory(0L);
        assertTrue(Objects.nonNull(category));
    }
}