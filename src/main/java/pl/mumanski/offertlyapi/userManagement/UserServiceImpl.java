package pl.mumanski.offertlyapi.userManagement;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import pl.mumanski.offertlyapi.userManagement.dto.CreateUserDto;

@Service
@RequiredArgsConstructor
@Slf4j
class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public User getUserById(Long id) {
        log.info("Searching repository for user with id = " + id);
        return userRepository
                .findById(id)
                .orElse(null);
    }

    public User save(CreateUserDto createUserDto) {
        User newUser = userRepository.save(UserMapper.INSTANCE.toUser(createUserDto));
        log.info("Saved new user in repository with id = " + newUser.getId());
        return newUser;
    }
}
