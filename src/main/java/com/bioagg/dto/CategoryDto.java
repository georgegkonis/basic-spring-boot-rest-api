package com.bioagg.dto;

import java.io.Serializable;
import java.util.Set;

/**
 * DTO for {@link com.bioagg.entity.Category}
 */
public record CategoryDto(
        Long id, String name, String description, Set<String> productNames
) implements Serializable {}