package pl.mumanski.offertlyapi.userManagement;

import pl.mumanski.offertlyapi.userManagement.dto.CreateUserDto;

import java.util.List;

public interface UserService {
    List<User> getAllUsers();

    User getUserById(Long id);

    User getUserByCredentials(String username, String password);

    User register(CreateUserDto createUserDto);
}
