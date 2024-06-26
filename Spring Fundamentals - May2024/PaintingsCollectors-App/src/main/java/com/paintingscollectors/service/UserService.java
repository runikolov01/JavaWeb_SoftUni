package com.paintingscollectors.service;

import com.paintingscollectors.model.dto.UserLoginDTO;
import com.paintingscollectors.model.dto.UserRegisterDTO;
import com.paintingscollectors.model.entity.Painting;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public interface UserService {
    boolean register(UserRegisterDTO data);

    boolean login(UserLoginDTO data);

    Set<Painting> findFavourites(Long id);
}
