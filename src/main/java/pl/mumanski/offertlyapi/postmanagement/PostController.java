package pl.mumanski.offertlyapi.postmanagement;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.mumanski.offertlyapi.postmanagement.model.dto.CreatePostDto;
import pl.mumanski.offertlyapi.postmanagement.model.dto.PostDto;
import pl.mumanski.offertlyapi.postmanagement.model.entity.Post;

import javax.persistence.NoResultException;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.Collections;
import java.util.List;

@RestController
@RequiredArgsConstructor
@Slf4j
class PostController {

    private final PostService postService;

    @Operation(operationId = "createPost", summary = "Create Post", tags = {"Post"},
            responses = {
                    @ApiResponse(responseCode = "201", description = "OK", content = @Content(
                            mediaType = MediaType.APPLICATION_JSON_VALUE,
                            schema = @Schema(implementation = PostDto.class)
                    )),
                    @ApiResponse(responseCode = "401", description = "Unauthorized"),
            }
    )
    @RequestMapping(method = RequestMethod.POST, value = "/post", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<PostDto> createPost(@RequestBody CreatePostDto createPostDto) {
        Post post = postService.create(createPostDto);
        PostDto postDto = PostMapper.INSTANCE.toPostDto(post);
        return new ResponseEntity<>(postDto, HttpStatus.CREATED);
    }

    @Operation(operationId = "getPost", summary = "Retrieve Post", tags = {"Post"},
            responses = {
                    @ApiResponse(responseCode = "200", description = "OK", content = @Content(
                            mediaType = MediaType.APPLICATION_JSON_VALUE,
                            schema = @Schema(implementation = PostDto.class)
                    )),
                    @ApiResponse(responseCode = "401", description = "Unauthorized"),
                    @ApiResponse(responseCode = "404", description = "Not Found")
            }
    )
    @RequestMapping(method = RequestMethod.GET, value = "/post/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<PostDto> getPost(@PathVariable @Valid @NotNull Long id) {
        try {
            Post post = postService.getPostById(id);
            PostDto postDto = PostMapper.INSTANCE.toPostDto(post);
            return new ResponseEntity<>(postDto, HttpStatus.OK);
        } catch (NoResultException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @Operation(operationId = "getAllPosts", summary = "Retrieve All Posts", tags = {"Post"},
            responses = {
                    @ApiResponse(responseCode = "200", description = "OK", content = @Content(
                            mediaType = MediaType.APPLICATION_JSON_VALUE,
                            array = @ArraySchema(schema = @Schema(implementation = PostDto.class))
                    )),
                    @ApiResponse(responseCode = "401", description = "Unauthorized"),
                    @ApiResponse(responseCode = "404", description = "Not Found")
            }
    )
    @RequestMapping(method = RequestMethod.GET, value = "/post", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<PostDto>> getPosts() {

        List<PostDto> posts = postService.getAllPosts()
                .stream()
                .map(PostMapper.INSTANCE::toPostDto)
                .toList();

        if (posts.isEmpty()) {
            return new ResponseEntity<>(Collections.emptyList(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(posts, HttpStatus.OK);
        }

    }

}
