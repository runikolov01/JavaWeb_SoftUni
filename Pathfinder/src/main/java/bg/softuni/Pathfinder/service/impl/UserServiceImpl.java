package bg.softuni.Pathfinder.service.impl;

import bg.softuni.Pathfinder.model.User;
import bg.softuni.Pathfinder.model.dto.UserRegisterDTO;
import bg.softuni.Pathfinder.repository.UserRepository;
import bg.softuni.Pathfinder.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    @Override
    public void register(UserRegisterDTO userRegisterDTO) {
        User user = new User(); // TODO: to convert userRegisterDTO with modelMap
        // TODO: Implement register process


        userRepository.save(user);
    }
}
