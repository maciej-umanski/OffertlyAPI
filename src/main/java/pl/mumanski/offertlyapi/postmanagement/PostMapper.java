package pl.mumanski.offertlyapi.postmanagement;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import pl.mumanski.offertlyapi.postmanagement.model.dto.CreatePostDto;
import pl.mumanski.offertlyapi.postmanagement.model.dto.PostDto;
import pl.mumanski.offertlyapi.postmanagement.model.entity.Post;

@Mapper(componentModel = "spring")
interface PostMapper {
    PostMapper INSTANCE = Mappers.getMapper(PostMapper.class);

    Post toPost(CreatePostDto createPostDto);

    PostDto toPostDto(Post post);
}
