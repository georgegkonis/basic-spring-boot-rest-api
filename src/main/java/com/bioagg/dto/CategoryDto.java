package com.bioagg.dto;

import java.io.Serializable;

/**
 * DTO for {@link com.bioagg.entity.Category}
 */
public record CategoryDto(
        Long id,
        String name,
        String description
) implements Serializable {}