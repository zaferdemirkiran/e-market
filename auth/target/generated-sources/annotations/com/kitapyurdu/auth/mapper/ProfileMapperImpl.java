package com.kitapyurdu.auth.mapper;

import com.kitapyurdu.auth.dto.ProfileDto;
import com.kitapyurdu.auth.entity.Profile;
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
public class ProfileMapperImpl implements ProfileMapper {

    @Override
    public ProfileDto toResource(Profile e) {
        if ( e == null ) {
            return null;
        }

        ProfileDto profileDto = new ProfileDto();

        profileDto.profileId = e.getProfileId();

        return profileDto;
    }

    @Override
    public Profile toEntity(ProfileDto r) {
        if ( r == null ) {
            return null;
        }

        Profile profile = new Profile();

        profile.setProfileId( r.profileId );

        return profile;
    }

    @Override
    public List<ProfileDto> toResourse(List<Profile> eList) {
        if ( eList == null ) {
            return null;
        }

        List<ProfileDto> list = new ArrayList<ProfileDto>( eList.size() );
        for ( Profile profile : eList ) {
            list.add( toResource( profile ) );
        }

        return list;
    }

    @Override
    public List<Profile> toEntity(List<ProfileDto> rList) {
        if ( rList == null ) {
            return null;
        }

        List<Profile> list = new ArrayList<Profile>( rList.size() );
        for ( ProfileDto profileDto : rList ) {
            list.add( toEntity( profileDto ) );
        }

        return list;
    }
}
