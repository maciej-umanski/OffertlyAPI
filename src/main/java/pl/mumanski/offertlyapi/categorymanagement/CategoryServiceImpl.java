package pl.mumanski.offertlyapi.categorymanagement;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import pl.mumanski.offertlyapi.categorymanagement.model.dto.CreateCategoryDto;
import pl.mumanski.offertlyapi.categorymanagement.model.entity.Category;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;

    public Category create(CreateCategoryDto createCategoryDto) {
        Category category = categoryRepository.save(CategoryMapper.INSTANCE.toCategory(createCategoryDto));
        log.info("Saved category object {} to database", category);
        return category;
    }

    public List<Category> getAllCategories() {
        log.info("Retrieving all categories from repository");
        return categoryRepository.findAll();
    }
}
