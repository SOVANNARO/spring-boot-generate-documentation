package org.tutorials.springBootGenerateDocumentation.service.impl;

import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.tutorials.springBootGenerateDocumentation.exception.EmailAlreadyExistsException;
import org.tutorials.springBootGenerateDocumentation.exception.ResourceNotFoundException;
import org.tutorials.springBootGenerateDocumentation.repository.UserRepository;
import org.tutorials.springBootGenerateDocumentation.service.UserService;
import org.tutorials.springBootGenerateDocumentation.dto.UserDto;
import org.tutorials.springBootGenerateDocumentation.entity.User;
import org.tutorials.springBootGenerateDocumentation.mapper.AutoUserMapper;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {
    private UserRepository userRepository;

    // config model mapper library
    private ModelMapper modelMapper;

    @Override
    public UserDto createUser(UserDto userDto) {

        Optional<User> optionalUser = userRepository.findByEmail(userDto.getEmail());

        if (optionalUser.isPresent()) {
            throw new EmailAlreadyExistsException("Email already exists");
        }

        // Convert UserDto into User JPA Entity
        // Config mapstruct to convert UserDto into User JPA Entity
        User user = AutoUserMapper.MAPPER.mapToUser(userDto);

        User savedUser = userRepository.save(user);

        // Config mapstruct to convert User JPA Entity into UserDto
        UserDto savedUserDto = AutoUserMapper.MAPPER.mapToUserDto(savedUser);

        // Return UserDto
        return savedUserDto;
    }

    @Override
    public UserDto getUserById(Long id) {
        User user = userRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("User not found", "id", id)
        );
        return AutoUserMapper.MAPPER.mapToUserDto(user);
    }

    @Override
    public List<UserDto> getAllUsers() {
        List<User> users = userRepository.findAll();
        // return users.stream().map(UserMapper::mapToUserDto).collect(Collectors.toList());
        // config model mapper library
        // return users.stream().map(user -> modelMapper.map(user, UserDto.class)).collect(Collectors.toList());

        // Config mapstruct library
        return users.stream().map(AutoUserMapper.MAPPER::mapToUserDto).collect(Collectors.toList());
    }

    @Override
    public UserDto updateUser(UserDto user) {
        User existingUser = userRepository.findById(user.getId()).orElseThrow(
                () -> new ResourceNotFoundException("User not found", "id", user.getId())
        );
        existingUser.setFirstName(user.getFirstName());
        existingUser.setLastName(user.getLastName());
        existingUser.setEmail(user.getEmail());
        User updatedUser = userRepository.save(existingUser);

        // Config mapstruct library
        return AutoUserMapper.MAPPER.mapToUserDto(updatedUser);
    }

    @Override
    public void deleteUser(Long id) {
        User user = userRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("User not found", "id", id)
        );
        userRepository.deleteById(id);
    }
}
