package pl.mumanski.offertlyapi.postmanagement;

import pl.mumanski.offertlyapi.postmanagement.model.dto.CreatePostDto;
import pl.mumanski.offertlyapi.postmanagement.model.entity.Post;

import java.util.List;

interface PostService {
    Post create(CreatePostDto createPostDto);

    Post getPostById(Long id);

    List<Post> getAllPosts();
}
