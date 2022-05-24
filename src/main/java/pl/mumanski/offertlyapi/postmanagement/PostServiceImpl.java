package pl.mumanski.offertlyapi.postmanagement;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import pl.mumanski.offertlyapi.postmanagement.model.dto.CreatePostDto;
import pl.mumanski.offertlyapi.postmanagement.model.entity.Post;

import javax.persistence.NoResultException;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
class PostServiceImpl implements PostService{

    private final PostRepository postRepository;

    public Post create(CreatePostDto createPostDto) {
        Post post = postRepository.save(PostMapper.INSTANCE.toPost(createPostDto));
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
}
