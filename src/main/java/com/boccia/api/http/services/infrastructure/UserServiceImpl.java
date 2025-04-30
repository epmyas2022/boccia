package com.boccia.api.http.services.infrastructure;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.stereotype.Service;

import com.boccia.api.http.dto.UserDto;
import com.boccia.api.http.services.domain.UserService;
import com.boccia.api.model.User;
import com.boccia.api.repositories.UserRepository;

import com.boccia.api.http.converter.Converter;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final Converter.Model<UserDto, User> userConverter;

    public UserServiceImpl(UserRepository userRepository, Converter.Model<UserDto, User> userConverter) {
        this.userConverter = userConverter;
        this.userRepository = userRepository;
    }

    @Override
    public List<UserDto> findAll() {

        return userRepository.findAll()
                .stream()
                .map(this.userConverter::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public UserDto findByEmail(String email) {
        throw new UnsupportedOperationException("Unimplemented method 'findByEmail'");
    }

    @Override
    public UserDto create(UserDto user) {
        throw new UnsupportedOperationException("Unimplemented method 'create'");
    }

    @Override
    public UserDto update(Long id, UserDto user) {
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    @Override
    public void delete(Long id) {
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }

}
