package pl.mumanski.offertlyapi.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import pl.mumanski.offertlyapi.model.dto.UpdateUserDto;
import pl.mumanski.offertlyapi.model.entity.User;
import pl.mumanski.offertlyapi.model.dto.CreateUserDto;
import pl.mumanski.offertlyapi.model.dto.UserDto;

@Mapper(componentModel = "spring")
public interface UserMapper {
    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    User toUser(CreateUserDto user);
    User toUser(UpdateUserDto user);
    UserDto toUserDto(User user);
}
