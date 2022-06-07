package pl.mumanski.offertlyapi.categorymanagement;

import pl.mumanski.offertlyapi.categorymanagement.model.dto.CreateCategoryDto;
import pl.mumanski.offertlyapi.categorymanagement.model.entity.Category;

import java.util.List;

public interface CategoryService {
    Category create(CreateCategoryDto createCategoryDto);

    List<Category> getAllCategories();

    Category getCategory(Long id);
}
