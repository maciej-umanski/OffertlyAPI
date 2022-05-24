package pl.mumanski.offertlyapi.usermanagement;

import pl.mumanski.offertlyapi.usermanagement.model.dto.CreateCommentDto;
import pl.mumanski.offertlyapi.usermanagement.model.dto.UpdateUserDto;
import pl.mumanski.offertlyapi.usermanagement.model.entity.User;
import pl.mumanski.offertlyapi.usermanagement.model.dto.CreateUserDto;

import java.util.List;

interface UserService {
    List<User> getAllUsers();
    User getUserById(Long id);
    User getUserByCredentials(String username, String password);
    User register(CreateUserDto createUserDto);
    User put(UpdateUserDto updateUserDto, Long Id);
    User addComment(CreateCommentDto createCommentDto, Long id);
}
