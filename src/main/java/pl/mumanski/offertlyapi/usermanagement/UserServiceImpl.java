package pl.mumanski.offertlyapi.usermanagement;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import pl.mumanski.offertlyapi.postmanagement.PostService;
import pl.mumanski.offertlyapi.usermanagement.model.dto.CreateCommentDto;
import pl.mumanski.offertlyapi.usermanagement.model.dto.CreateUserDto;
import pl.mumanski.offertlyapi.usermanagement.model.dto.UpdateUserDto;
import pl.mumanski.offertlyapi.usermanagement.model.entity.Availability;
import pl.mumanski.offertlyapi.usermanagement.model.entity.Comment;
import pl.mumanski.offertlyapi.usermanagement.model.entity.User;

import javax.persistence.NoResultException;
import javax.transaction.Transactional;
import java.time.OffsetDateTime;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
@Slf4j
@Transactional
class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final PostService postService;

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
        User user = userRepository
                .findUserByUsernameAndPassword(username, password)
                .orElseThrow(NoResultException::new);

        user.setLastActive(OffsetDateTime.now());

        user = userRepository.save(user);

        return user;
    }

    public User register(CreateUserDto createUserDto) {
        User newUser = UserMapper.INSTANCE.toUser(createUserDto);

        newUser.setLastActive(OffsetDateTime.now());
        if(Objects.isNull(newUser.getAvailability())) {
            newUser.setAvailability(Availability.empty());
        }

        userRepository.save(newUser);

        log.info("Saved new user in repository with id = " + newUser.getId());
        return newUser;
    }

    public User put(UpdateUserDto updateUserDto, Long id) {
        User existingUser = getUserById(id);

        User newUser = UserMapper.INSTANCE.toUser(updateUserDto);

        newUser.setId(existingUser.getId());
        newUser.setUsername(existingUser.getUsername());
        newUser.setLastActive(existingUser.getLastActive());
        newUser.setCreated(existingUser.getCreated());

        log.info("Updated user in repository with id = " + newUser.getId());

        newUser = userRepository.save(newUser);

        return newUser;
    }

    public User addComment(CreateCommentDto createCommentDto, Long id) {
        User existingUser = getUserById(id);
        Comment comment = UserMapper.INSTANCE.toComment(createCommentDto);

        List<Comment> comments = existingUser.getComments();

        if (Objects.isNull(comments)) {
            comments = new LinkedList<>();
        }

        comments.add(comment);
        existingUser = userRepository.save(existingUser);
        log.info("Added comment to user with id = {}, and content {}", id, comment);

        return existingUser;
    }

    public void deleteUser(Long id) {
        log.info("Deleted user with id = " + id);
        postService.deletePostsByAuthorId(id);
        userRepository.deleteById(id);
    }
}
