package org.tutorials.springBootGenerateDocumentation.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.tutorials.springBootGenerateDocumentation.dto.UserDto;
import org.tutorials.springBootGenerateDocumentation.entity.User;

@Mapper
public interface AutoUserMapper {
    AutoUserMapper MAPPER = Mappers.getMapper(AutoUserMapper.class);

    UserDto mapToUserDto(User user);

    User mapToUser(UserDto userDto);
}
