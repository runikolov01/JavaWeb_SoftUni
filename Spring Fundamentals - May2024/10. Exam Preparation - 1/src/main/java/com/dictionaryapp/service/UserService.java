package com.dictionaryapp.service;

import com.dictionaryapp.model.entity.UserRegisterDTO;
import org.springframework.stereotype.Service;

@Service
public interface UserService {
    boolean registerUser(UserRegisterDTO userRegisterDTO);
}
