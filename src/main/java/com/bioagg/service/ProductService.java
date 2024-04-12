package com.bioagg.service;

import com.bioagg.repository.ProductRepository;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@NoArgsConstructor
public class ProductService {

    private ProductRepository productRepository;
}
