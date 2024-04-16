package com.bioagg.service;

import com.bioagg.dto.CategoryDto;
import com.bioagg.entity.Category;
import com.bioagg.repository.CategoryRepository;
import lombok.NoArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@NoArgsConstructor
public class CategoryService {

    private CategoryRepository categoryRepository;
    private ModelMapper mapper;

    public CategoryDto add(CategoryDto categoryDto) {
        var category = mapper.map(categoryDto, Category.class);
        var addedCategory = categoryRepository.save(category);

        return mapper.map(addedCategory, CategoryDto.class);
    }

    public CategoryDto update(CategoryDto categoryDto) {
        var category = mapper.map(categoryDto, Category.class);
        var updatedCategory = categoryRepository.save(category);

        return mapper.map(updatedCategory, CategoryDto.class);
    }

    public void delete(Long categoryId) {
        categoryRepository.deleteById(categoryId);
    }

    public CategoryDto get(Long categoryId) {
        var category = categoryRepository.findById(categoryId).orElseThrow();

        return mapper.map(category, CategoryDto.class);
    }

    public List<CategoryDto> getAll() {
        var categories = categoryRepository.findAll();

        return categories.stream()
                .map(category -> mapper.map(category, CategoryDto.class))
                .collect(Collectors.toList());
    }
}
