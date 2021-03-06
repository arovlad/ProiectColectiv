package ro.ubb.mappers;

import ro.ubb.dtos.UserDto;
import ro.ubb.models.User;

public class UserDTOMapper {

    public static User mapUserDtoToUser(UserDto userDto) {
        User user = new User();
        user.setId(userDto.getUserId());
        user.setPassword(userDto.getPassword());
        user.setUsername(userDto.getUsername());
        user.setEmail(userDto.getEmail());

        return user;
    }

    public static UserDto mapUserToUserDto(User user) {
        UserDto userDto = new UserDto();
        userDto.setUserId(user.getId());
        userDto.setPassword(user.getPassword());
        userDto.setUsername(user.getUsername());
        userDto.setEmail(user.getEmail());

        return userDto;
    }
}