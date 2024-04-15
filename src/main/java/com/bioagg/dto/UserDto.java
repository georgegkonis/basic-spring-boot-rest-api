package com.bioagg.dto;

import java.io.Serializable;

/**
 * DTO for {@link com.bioagg.entity.User}
 */
public record UserDto(
        Long id, String username, String email, String firstName, String lastName
) implements Serializable {}