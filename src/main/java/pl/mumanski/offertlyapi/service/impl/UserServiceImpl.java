package pl.mumanski.offertlyapi.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import pl.mumanski.offertlyapi.mapper.UserMapper;
import pl.mumanski.offertlyapi.model.dto.UpdateUserDto;
import pl.mumanski.offertlyapi.model.entity.User;
import pl.mumanski.offertlyapi.model.dto.CreateUserDto;
import pl.mumanski.offertlyapi.repository.UserRepository;
import pl.mumanski.offertlyapi.service.UserService;

import javax.persistence.NoResultException;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public List<User> getAllUsers() {
        log.info("Retrieving all users from repository");
        return userRepository.findAll();
    }

    public User getUserById(Long id) {
        log.info("Searching repository for user with id = " + id);
        return userRepository
                .findById(id)
                .orElseThrow(NoResultException::new);
    }

    public User getUserByCredentials(String username, String password) {
        log.info("Searching repository for user with username = " + username);
        return userRepository
                .findUserByUsernameAndPassword(username, password)
                .orElseThrow(NoResultException::new);
    }

    public User register(CreateUserDto createUserDto) {
        User newUser = userRepository.save(UserMapper.INSTANCE.toUser(createUserDto));
        log.info("Saved new user in repository with id = " + newUser.getId());
        return newUser;
    }

    public User put(UpdateUserDto updateUserDto, Long id) {

        User existingUser = getUserById(id);

        User newUser = UserMapper.INSTANCE.toUser(updateUserDto);
        newUser.setId(existingUser.getId());

        return userRepository.save(newUser);
    }
}
