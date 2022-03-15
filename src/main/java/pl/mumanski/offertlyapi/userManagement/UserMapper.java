package pl.mumanski.offertlyapi.userManagement;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import pl.mumanski.offertlyapi.userManagement.dto.CreateUserDto;
import pl.mumanski.offertlyapi.userManagement.dto.UserDto;

@Mapper(componentModel = "spring")
interface UserMapper {
    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    User toUser(CreateUserDto user);
    UserDto toUserDto(User user);
}
