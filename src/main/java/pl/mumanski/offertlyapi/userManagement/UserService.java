package pl.mumanski.offertlyapi.userManagement;

import java.util.List;

public interface UserService {
    List<User> getAllUsers();

    User getUserById(Long id);

    User getUserByCredentials(String username, String password);

    User register(CreateUserDto createUserDto);
}
