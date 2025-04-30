package com.boccia.api.http.converter;

import org.springframework.stereotype.Component;

import com.boccia.api.http.dto.UserDto;
import com.boccia.api.model.User;

@Component
public class UserConverter implements Converter.Model<UserDto, User> {

    @Override
    public UserDto toDto(User model) {
        return new UserDto(model.getId(), model.getName(),
                model.getEmail(), model.getPassword(),
                model.getRole());
    }

    @Override
    public User toModel(UserDto dto) {
        User user = new User();
        user.setId(dto.id());
        user.setName(dto.name());
        user.setEmail(dto.email());
        user.setPassword(dto.password());
        user.setRole(dto.role());

        return user;
    }

}
