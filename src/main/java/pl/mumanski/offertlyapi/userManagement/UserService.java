package pl.mumanski.offertlyapi.userManagement;

import pl.mumanski.offertlyapi.userManagement.dto.CreateUserDto;

public interface UserService {
    User getUserById(Long id);
    User save(CreateUserDto createUserDto);
}
