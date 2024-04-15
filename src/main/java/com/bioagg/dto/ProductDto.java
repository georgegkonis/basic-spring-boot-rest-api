package com.bioagg.dto;

import java.io.Serializable;

/**
 * DTO for {@link com.bioagg.entity.Product}
 */
public record ProductDto(
        Long id, String categoryName, String name, Double price, Integer stock, String description
) implements Serializable {}