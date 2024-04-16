package com.bioagg.controller;

import com.bioagg.dto.CategoryDto;
import com.bioagg.service.CategoryService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/categories")
@AllArgsConstructor
public class CategoryController {

    private final CategoryService categoryService;

    @GetMapping
    public ResponseEntity<List<CategoryDto>> getAllCategories() {
        var categories = categoryService.getAll();

        return ResponseEntity.ok(categories);
    }

    @GetMapping("{categoryId}")
    public ResponseEntity<CategoryDto> getCategory(
            @PathVariable Long categoryId
    ) {
        var category = categoryService.get(categoryId);

        return ResponseEntity.ok(category);
    }

    @PostMapping
    public ResponseEntity<CategoryDto> addCategory(
            @RequestBody CategoryDto categoryDto
    ) {
        var category = categoryService.add(categoryDto);

        return ResponseEntity.ok(category);
    }

    @PutMapping
    public ResponseEntity<CategoryDto> updateCategory(
            @RequestBody CategoryDto categoryDto
    ) {
        var category = categoryService.update(categoryDto);

        return ResponseEntity.ok(category);
    }

    @DeleteMapping("{categoryId}")
    public ResponseEntity<Void> deleteCategory(
            @PathVariable Long categoryId
    ) {
        categoryService.delete(categoryId);

        return ResponseEntity.noContent().build();
    }
}
