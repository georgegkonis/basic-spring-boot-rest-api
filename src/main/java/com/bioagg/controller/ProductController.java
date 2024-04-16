package com.bioagg.controller;

import com.bioagg.dto.ProductDto;
import com.bioagg.service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/products")
@AllArgsConstructor
public class ProductController {

    private final ProductService productService;

    @GetMapping
    public ResponseEntity<List<ProductDto>> getProducts() {

        throw new UnsupportedOperationException("Not implemented yet");
    }

    @GetMapping("{productId}")
    public ResponseEntity<ProductDto> getProduct(
            @PathVariable("productId") Long productId
    ) {

        throw new UnsupportedOperationException("Not implemented yet");
    }

    @PostMapping
    public ResponseEntity<ProductDto> createProduct(
            @RequestBody ProductDto productDto
    ) {

        throw new UnsupportedOperationException("Not implemented yet");
    }

    @PutMapping("{productId}")
    public ResponseEntity<ProductDto> updateProduct(
            @PathVariable("productId") Long productId, @RequestBody ProductDto productDto
    ) {

        throw new UnsupportedOperationException("Not implemented yet");
    }

    @DeleteMapping("{productId}")
    public ResponseEntity<Void> deleteProduct(
            @PathVariable("productId") Long productId
    ) {

        throw new UnsupportedOperationException("Not implemented yet");
    }
}
