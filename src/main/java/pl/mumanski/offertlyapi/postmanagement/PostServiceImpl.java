package pl.mumanski.offertlyapi.postmanagement;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import pl.mumanski.offertlyapi.categorymanagement.CategoryService;
import pl.mumanski.offertlyapi.categorymanagement.model.entity.Category;
import pl.mumanski.offertlyapi.postmanagement.model.dto.CreatePostDto;
import pl.mumanski.offertlyapi.postmanagement.model.entity.Post;
import pl.mumanski.offertlyapi.usermanagement.UserRepository;
import pl.mumanski.offertlyapi.usermanagement.model.entity.User;

import javax.persistence.NoResultException;
import javax.transaction.Transactional;
import java.time.OffsetDateTime;
import java.util.Collections;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
@Transactional
class PostServiceImpl implements PostService {

    private final PostRepository postRepository;
    private final CategoryService categoryService;
    private final UserRepository userRepository;

    public Post create(CreatePostDto createPostDto) {
        Post post = PostMapper.INSTANCE.toPost(createPostDto);

        List<Long> categoriesId = !post.getCategories().isEmpty()
                ? post.getCategories().stream().map(Category::getId).toList()
                : Collections.emptyList();
        Long authorId = createPostDto.getAuthorId();

        List<Category> categories = categoriesId.stream().map(categoryService::getCategory).toList();
        User user = userRepository.getById(authorId);

        post.setAuthor(user);
        post.setCategories(categories);
        post.setCreated(OffsetDateTime.now());

        postRepository.save(post);

        log.info("Saved object {} to database", post);
        return post;
    }

    public Post getPostById(Long id) {
        log.info("Searching repository for post with id = " + id);
        return postRepository
                .findById(id)
                .orElseThrow(NoResultException::new);
    }

    public List<Post> getAllPosts() {
        log.info("Retrieving all posts from repository");
        return postRepository.findAll();
    }

    public Post reportPost(Long id) {
        log.info("Searching repository for post with id = " + id);
        Post post = postRepository
                .findById(id)
                .orElseThrow(NoResultException::new);

        post.setReportCount(post.getReportCount() + 1);

        log.info("Increased report count by one for post with id = " + id);
        return postRepository.save(post);
    }

    public void deletePostsByAuthorId(Long authorId) {
        log.info("Deleted posts for user with id = " + authorId);
        postRepository.deleteAllByAuthorId(authorId);
    }

    public void deletePostById(Long id) {
        log.info("Deleted post with id = " + id);
        postRepository.deleteById(id);
    }
}
