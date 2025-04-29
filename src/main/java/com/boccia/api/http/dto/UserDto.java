package com.boccia.api.http.dto;

import com.boccia.api.enums.TypeRole;

public record UserDto(Long id,
        String name, String email, String password, TypeRole role) {
}
