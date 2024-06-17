package com.dictionaryapp.service.impl;

import com.dictionaryapp.model.entity.User;
import com.dictionaryapp.model.entity.UserLoginDTO;
import com.dictionaryapp.model.entity.UserRegisterDTO;
import com.dictionaryapp.repo.UserRepository;
import com.dictionaryapp.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final ModelMapper modelMapper;
    private final PasswordEncoder passwordEncoder;

    public UserServiceImpl(UserRepository userRepository, ModelMapper modelMapper, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public boolean registerUser(UserRegisterDTO data) {
        if (!data.getPassword().equals(data.getConfirmPassword())) {
            return false;
        }

        boolean isUsernameOrEmailTaken =
                userRepository.existsByUsernameOrEmail(data.getUsername(), data.getEmail());
        if (isUsernameOrEmailTaken) {
            return false;
        }

        User mapped = modelMapper.map(data, User.class);
        mapped.setPassword(passwordEncoder.encode(mapped.getPassword()));

        userRepository.save(mapped);

        return true;
    }

    @Override
    public boolean loginUser(UserLoginDTO userLoginDTO) {
        Optional<User> byUsername = userRepository.getUserByUsername(userLoginDTO.getUsername());
        if (byUsername.isEmpty()) {
            return false;
        }
        User user = byUsername.get();

        if (user.getPassword().equals(passwordEncoder.encode(userLoginDTO.getPassword()))) {
            return true;
        }

        //add to session

        return true;
    }
}