package dev.cat.user;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void createUser(UserRequest userRequest) {

        User user = UserMapper.INSTANCE.mapDtoToUser(userRequest);
        userRepository.save(user);
    }

    public List<UserResponse> findAll() {

        return userRepository.findAll()
                .stream()
                .map(UserMapper.INSTANCE::mapUserToDto)
                .toList();

    }

}








