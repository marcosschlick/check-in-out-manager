package com.checkinout.manager.services;

import com.checkinout.manager.dtos.UserCreateDTO;
import com.checkinout.manager.dtos.UserResponseDTO;
import com.checkinout.manager.entities.User;
import com.checkinout.manager.exceptions.DuplicateResourceException;
import com.checkinout.manager.repositories.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Transactional
    public UserResponseDTO registerUser(UserCreateDTO dto) {
        List<String> errors = new ArrayList<>();

        if (userRepository.existsByEmail(dto.getEmail())) {
            errors.add("Email already registered");
        }
        if (userRepository.existsByDocument(dto.getDocument())) {
            errors.add("Document already registered");
        }

        if (!errors.isEmpty()) {
            throw new DuplicateResourceException(String.join("; ", errors));
        }

        User user = new User();
        user.setName(dto.getName());
        user.setDocument(dto.getDocument());
        user.setEmail(dto.getEmail());
        user.setBirthDate(dto.getBirthDate());
        user.setPasswordHash(passwordEncoder.encode(dto.getPassword()));
        user.setImageUrl(dto.getImageUrl());

        User savedUser = userRepository.save(user);

        return new UserResponseDTO(savedUser);
    }
}
