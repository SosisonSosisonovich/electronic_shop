package com.example.backend.Mappers;

import com.example.backend.DTO.CategoryDTO;
import com.example.backend.Entity.Category;
import org.mapstruct.Mapper;
import java.util.List;

@Mapper(componentModel = "spring")
public interface CategoryMappers {
    CategoryDTO toDTO(Category category);
    Category toEntity(CategoryDTO categoryDTO);
    List<CategoryDTO> toDTOList(List<Category> categories);
}
