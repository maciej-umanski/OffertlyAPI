package pl.mumanski.offertlyapi.postmanagement;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import pl.mumanski.offertlyapi.postmanagement.model.dto.CreatePostDto;
import pl.mumanski.offertlyapi.postmanagement.model.entity.Post;
import pl.mumanski.offertlyapi.usermanagement.UserService;
import pl.mumanski.offertlyapi.usermanagement.model.dto.CreateUserDto;
import pl.mumanski.offertlyapi.usermanagement.model.entity.User;

import javax.persistence.NoResultException;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class PostServiceTest {

    @Autowired
    private PostService postService;

    @Autowired
    private UserService userService;


    @Test
    void create() {
        User user = createUser();
        Post post = createPost(user.getId());
        assertTrue(Objects.nonNull(post.getId()));
    }

    @Test
    void getPostById() {
        User user = createUser();
        Post post = createPost(user.getId());
        Post postRetrieved = postService.getPostById(post.getId());
        assertTrue(Objects.nonNull(postRetrieved) && Objects.nonNull(postRetrieved.getId()));
    }

    @Test
    void getAllPosts() {
        User user = createUser();
        for(int i = 0; i < 5; i++){
            createPost(user.getId());
        }
        List<Post> postsRetrieved = postService.getAllPosts();
        assertTrue(Objects.nonNull(postsRetrieved) && !postsRetrieved.isEmpty());
    }

    @Test
    void reportPost() {
        User user = createUser();
        Post post = createPost(user.getId());

        int oldReportCount = post.getReportCount();
        Post postRetrieved = postService.reportPost(post.getId());

        assertTrue(Objects.nonNull(postRetrieved) && postRetrieved.getReportCount() > oldReportCount);
    }

    @Test
    void deletePostsByAuthorId() {
        User user = createUser();

        for(int i = 0; i < 5; i++){
            createPost(user.getId());
        }

        List<Post> retrievedPosts1 = postService.getAllPosts()
                .stream().filter(post -> post.getAuthor().getId().equals(user.getId())).toList();
        assertFalse(retrievedPosts1.isEmpty());

        postService.deletePostsByAuthorId(user.getId());

        List<Post> retrievedPosts2 = postService.getAllPosts()
                .stream().filter(post -> post.getAuthor().getId().equals(user.getId())).toList();
        assertTrue(retrievedPosts2.isEmpty());
    }

    @Test
    void deletePostById() {
        User user = createUser();
        Post post = createPost(user.getId());
        Post postRetrieved1 = postService.getPostById(post.getId());
        assertTrue(Objects.nonNull(postRetrieved1) && Objects.nonNull(postRetrieved1.getId()));
        postService.deletePostById(post.getId());
        assertThrows(NoResultException.class, () -> postService.getPostById(post.getId()));
    }

    private User createUser() {
        return userService.register(
                CreateUserDto.builder().username(String.valueOf(UUID.randomUUID())).password("test").build());
    }

    private Post createPost(Long userId) {
        return postService.create( CreatePostDto
                .builder()
                .authorId(userId)
                .categories(Collections.singletonList(1L))
                .city("Warszawa")
                .description("test")
                .price(20.44)
                .title("Test")
                .currency("USD")
                .build());
    }
}