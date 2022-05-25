package pl.mumanski.offertlyapi.usermanagement;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import pl.mumanski.offertlyapi.usermanagement.model.dto.CreateCommentDto;
import pl.mumanski.offertlyapi.usermanagement.model.dto.CreateUserDto;
import pl.mumanski.offertlyapi.usermanagement.model.dto.UpdateUserDto;
import pl.mumanski.offertlyapi.usermanagement.model.dto.UserDto;
import pl.mumanski.offertlyapi.usermanagement.model.entity.Comment;
import pl.mumanski.offertlyapi.usermanagement.model.entity.User;

@Mapper(componentModel = "spring")
interface UserMapper {
    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    User toUser(CreateUserDto user);

    User toUser(UpdateUserDto user);

    UserDto toUserDto(User user);

    Comment toComment(CreateCommentDto comment);
}
