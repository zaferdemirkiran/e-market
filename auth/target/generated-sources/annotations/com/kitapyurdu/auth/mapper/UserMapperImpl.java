package com.kitapyurdu.auth.mapper;

import com.kitapyurdu.auth.dto.UserDto;
import com.kitapyurdu.auth.entity.User;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-03-12T11:19:45+0300",
    comments = "version: 1.4.1.Final, compiler: javac, environment: Java 17.0.1 (Oracle Corporation)"
)
@Component
public class UserMapperImpl implements UserMapper {

    @Override
    public UserDto toResource(User e) {
        if ( e == null ) {
            return null;
        }

        UserDto userDto = new UserDto();

        userDto.userId = e.getUserId();
        userDto.userName = e.getUserName();
        userDto.userLastName = e.getUserLastName();
        userDto.password = e.getPassword();
        userDto.mail = e.getMail();
        userDto.profile = e.getProfile();

        return userDto;
    }

    @Override
    public User toEntity(UserDto r) {
        if ( r == null ) {
            return null;
        }

        User user = new User();

        user.setUserId( r.userId );
        user.setUserName( r.userName );
        user.setUserLastName( r.userLastName );
        user.setPassword( r.password );
        user.setMail( r.mail );
        user.setProfile( r.profile );

        return user;
    }

    @Override
    public List<UserDto> toResourse(List<User> eList) {
        if ( eList == null ) {
            return null;
        }

        List<UserDto> list = new ArrayList<UserDto>( eList.size() );
        for ( User user : eList ) {
            list.add( toResource( user ) );
        }

        return list;
    }

    @Override
    public List<User> toEntity(List<UserDto> rList) {
        if ( rList == null ) {
            return null;
        }

        List<User> list = new ArrayList<User>( rList.size() );
        for ( UserDto userDto : rList ) {
            list.add( toEntity( userDto ) );
        }

        return list;
    }
}
