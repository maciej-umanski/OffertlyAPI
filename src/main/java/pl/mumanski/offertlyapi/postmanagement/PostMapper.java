package pl.mumanski.offertlyapi.postmanagement;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import pl.mumanski.offertlyapi.postmanagement.model.dto.CreatePostDto;
import pl.mumanski.offertlyapi.postmanagement.model.dto.PostDto;
import pl.mumanski.offertlyapi.postmanagement.model.entity.Post;
import pl.mumanski.offertlyapi.usermanagement.model.dto.CreateCommentDto;
import pl.mumanski.offertlyapi.usermanagement.model.dto.CreateUserDto;
import pl.mumanski.offertlyapi.usermanagement.model.dto.UpdateUserDto;
import pl.mumanski.offertlyapi.usermanagement.model.dto.UserDto;
import pl.mumanski.offertlyapi.usermanagement.model.entity.Comment;
import pl.mumanski.offertlyapi.usermanagement.model.entity.User;

@Mapper(componentModel = "spring")
interface PostMapper {
    PostMapper INSTANCE = Mappers.getMapper(PostMapper.class);

    Post toPost(CreatePostDto createPostDto);
    PostDto toPostDto(Post post);
}
