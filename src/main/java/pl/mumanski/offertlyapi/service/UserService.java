package pl.mumanski.offertlyapi.service;

import pl.mumanski.offertlyapi.model.dto.UpdateUserDto;
import pl.mumanski.offertlyapi.model.entity.User;
import pl.mumanski.offertlyapi.model.dto.CreateUserDto;

import java.util.List;

public interface UserService {
    List<User> getAllUsers();

    User getUserById(Long id);

    User getUserByCredentials(String username, String password);

    User register(CreateUserDto createUserDto);

    User put(UpdateUserDto updateUserDto, Long Id);
}
