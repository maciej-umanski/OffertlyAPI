package pl.mumanski.offertlyapi.categorymanagement;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import pl.mumanski.offertlyapi.categorymanagement.model.dto.CategoryDto;
import pl.mumanski.offertlyapi.categorymanagement.model.dto.CreateCategoryDto;
import pl.mumanski.offertlyapi.categorymanagement.model.entity.Category;

@Mapper(componentModel = "spring")
interface CategoryMapper {
    CategoryMapper INSTANCE = Mappers.getMapper(CategoryMapper.class);

    Category toCategory(CreateCategoryDto createCategoryDto);

    CategoryDto toCategoryDto(Category category);
    CreateCategoryDto toCreateCategoryDto(Category category);
}
