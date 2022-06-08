package pl.mumanski.offertlyapi.usermanagement;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import pl.mumanski.offertlyapi.postmanagement.model.entity.Post;
import pl.mumanski.offertlyapi.usermanagement.model.dto.CreateCommentDto;
import pl.mumanski.offertlyapi.usermanagement.model.dto.CreateUserDto;
import pl.mumanski.offertlyapi.usermanagement.model.dto.UpdateUserDto;
import pl.mumanski.offertlyapi.usermanagement.model.entity.User;

import javax.persistence.NoResultException;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class UserServiceTest {

    @Autowired
    private UserService userService;

    @Test
    void getAllUsers() {
        for(int i = 0; i < 10; i++) {
            createUser();
        }
        List<User> usersRetrieved = userService.getAllUsers();
        assertTrue(Objects.nonNull(usersRetrieved) && !usersRetrieved.isEmpty());
    }

    @Test
    void getUserById() {
        User user = createUser();
        User retrievedUser = userService.getUserById(user.getId());
        assertTrue(Objects.nonNull(retrievedUser));
    }

    @Test
    void getUserByCredentials() {
        final String login = "login";
        final String password = "password";
        userService.register(
                CreateUserDto.builder().username(login).password(password).build());

        User retrievedUser = userService.getUserByCredentials(login, password);

        assertTrue(Objects.nonNull(retrievedUser)
                && retrievedUser.getUsername().equals(login)
                && retrievedUser.getPassword().equals(password));
    }

    @Test
    void register() {
        User user = createUser();
        assertTrue(Objects.nonNull(user) && Objects.nonNull(user.getId()));
    }

    @Test
    void put() {
        User user = createUser();
        assertTrue(Objects.nonNull(user) && Objects.nonNull(user.getId()) && user.getCity().equals("Kielce"));
        userService.put(UpdateUserDto.builder().city("Warszawa").password("test").build(), user.getId());
        User retrievedUser = userService.getUserById(user.getId());
        assertTrue(retrievedUser.getCity().equals("Warszawa"));

    }

    @Test
    void addComment() {
        User user = createUser();
        assertTrue(Objects.nonNull(user) && user.getComments().isEmpty());
        user = userService.addComment(CreateCommentDto.builder().comment("test").authorId(0L).rate(2.0).build(), user.getId());
        assertTrue(Objects.nonNull(user) && !user.getComments().isEmpty());
    }

    @Test
    void deleteUser() {
        User user = createUser();
        Long userId = user.getId();
        userService.deleteUser(user.getId());

        assertThrows(NoResultException.class, () -> userService.getUserById(userId));
    }

    private User createUser() {
        return userService.register(
                CreateUserDto.builder().username(String.valueOf(UUID.randomUUID())).password("test").city("Kielce").build());
    }
}