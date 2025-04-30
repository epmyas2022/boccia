package com.boccia.api.http.services.infrastructure;

import java.util.List;

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
                .toList();
    }

    @Override
    public UserDto findByEmail(String email) {
        return userRepository.findAll()
                .stream()
                .filter(user -> user.getEmail().equals(email))
                .map(this.userConverter::toDto)
                .findFirst()
                .orElse(null);
    }

    @Override
    public UserDto create(UserDto user) {
        User userToCreate = this.userConverter.toModel(user);
        User createdUser = userRepository.save(userToCreate);
        return this.userConverter.toDto(createdUser);
    }

    @Override
    public UserDto update(Long id, UserDto user) {
        User userToUpdate = userRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("User not found"));

        userToUpdate.setName(user.name());
        userToUpdate.setEmail(user.email());
        userToUpdate.setPassword(user.password());
        userToUpdate.setRole(user.role());

        return this.userConverter.toDto(userRepository.save(userToUpdate));
    }

    @Override
    public void delete(Long id) {
        User userToDelete = userRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("User not found"));

        userRepository.delete(userToDelete);
    }

}
