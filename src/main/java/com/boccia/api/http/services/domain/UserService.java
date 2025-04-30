package com.boccia.api.http.services.domain;

import java.util.List;
import com.boccia.api.http.dto.UserDto;

public interface UserService {
    List<UserDto> findAll();
    UserDto findByEmail(String email);
    UserDto create(UserDto user);
    UserDto update(Long id, UserDto user);
    void delete(Long id);
}
