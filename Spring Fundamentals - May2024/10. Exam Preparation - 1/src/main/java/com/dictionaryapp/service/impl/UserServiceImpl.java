package com.dictionaryapp.service.impl;

import com.dictionaryapp.model.entity.UserSession;
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

    private final UserSession userSession;

    public UserServiceImpl(UserRepository userRepository, ModelMapper modelMapper, PasswordEncoder passwordEncoder, UserSession userSession) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
        this.passwordEncoder = passwordEncoder;
        this.userSession = userSession;
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
        Optional<User> byUsername = userRepository.findByUsernameAndPassword(userLoginDTO.getUsername(), passwordEncoder.encode(userLoginDTO.getPassword()));

        //add to session
//        byUsername.map(user -> userSession.login(user);)
//                .isPresent();


        if (byUsername.isEmpty()) {
            return false;
        }

        User user = byUsername.get();

        userSession.login(user);

        return true;
    }
}