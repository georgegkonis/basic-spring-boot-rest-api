package com.bioagg.service;

import com.bioagg.repository.CategoryRepository;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@NoArgsConstructor
public class CategoryService {

    private CategoryRepository categoryRepository;
}
