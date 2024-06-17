package com.dictionaryapp.service;

import com.dictionaryapp.model.entity.UserLoginDTO;
import com.dictionaryapp.model.entity.UserRegisterDTO;
import org.springframework.stereotype.Service;

@Service
public interface UserService {
    boolean register(UserRegisterDTO data);
    
    boolean login(UserLoginDTO data);

    void logout();

}
