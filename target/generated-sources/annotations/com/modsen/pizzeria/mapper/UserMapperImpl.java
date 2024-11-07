package com.modsen.pizzeria.mapper;

import com.modsen.pizzeria.domain.Role;
import com.modsen.pizzeria.domain.RoleName;
import com.modsen.pizzeria.domain.User;
import com.modsen.pizzeria.dto.request.CreateUserRequest;
import com.modsen.pizzeria.dto.request.UpdateUserRequest;
import com.modsen.pizzeria.dto.response.RoleResponse;
import com.modsen.pizzeria.dto.response.UserResponse;
import java.time.LocalDate;
import javax.annotation.processing.Generated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-11-07T14:21:44+0300",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 21.0.1 (Oracle Corporation)"
)
@Component
public class UserMapperImpl implements UserMapper {

    @Autowired
    private RoleMapper roleMapper;

    @Override
    public UserResponse toUserResponse(User user) {
        if ( user == null ) {
            return null;
        }

        RoleResponse role = null;
        Long id = null;
        String firstname = null;
        String lastname = null;
        String password = null;
        String email = null;
        String gender = null;
        LocalDate birthDate = null;

        role = roleMapper.toRoleResponse( user.getRole() );
        id = user.getId();
        firstname = user.getFirstname();
        lastname = user.getLastname();
        password = user.getPassword();
        email = user.getEmail();
        gender = user.getGender();
        birthDate = user.getBirthDate();

        UserResponse userResponse = new UserResponse( id, firstname, lastname, password, email, gender, birthDate, role );

        return userResponse;
    }

    @Override
    public User toUser(UserResponse userResponse) {
        if ( userResponse == null ) {
            return null;
        }

        User.UserBuilder user = User.builder();

        user.id( userResponse.id() );
        user.firstname( userResponse.firstname() );
        user.lastname( userResponse.lastname() );
        user.email( userResponse.email() );
        user.password( userResponse.password() );
        user.gender( userResponse.gender() );
        user.birthDate( userResponse.birthDate() );
        user.role( roleResponseToRole( userResponse.role() ) );

        return user.build();
    }

    @Override
    public User toUser(CreateUserRequest createUserRequest, Role role) {
        if ( createUserRequest == null && role == null ) {
            return null;
        }

        User.UserBuilder user = User.builder();

        if ( createUserRequest != null ) {
            user.firstname( createUserRequest.firstname() );
            user.lastname( createUserRequest.lastname() );
            user.email( createUserRequest.email() );
            user.password( createUserRequest.password() );
            user.gender( createUserRequest.gender() );
            user.birthDate( createUserRequest.birthDate() );
        }
        user.role( role );

        return user.build();
    }

    @Override
    public User toUser(UpdateUserRequest updateUserRequest) {
        if ( updateUserRequest == null ) {
            return null;
        }

        User.UserBuilder user = User.builder();

        user.firstname( updateUserRequest.firstname() );
        user.lastname( updateUserRequest.lastname() );
        user.email( updateUserRequest.email() );
        user.password( updateUserRequest.password() );
        user.gender( updateUserRequest.gender() );
        user.birthDate( updateUserRequest.birthDate() );

        return user.build();
    }

    @Override
    public void updateUserFromRequest(UpdateUserRequest updateUserRequest, User user) {
        if ( updateUserRequest == null ) {
            return;
        }

        user.setFirstname( updateUserRequest.firstname() );
        user.setLastname( updateUserRequest.lastname() );
        user.setEmail( updateUserRequest.email() );
        user.setPassword( updateUserRequest.password() );
        user.setGender( updateUserRequest.gender() );
        user.setBirthDate( updateUserRequest.birthDate() );
    }

    protected Role roleResponseToRole(RoleResponse roleResponse) {
        if ( roleResponse == null ) {
            return null;
        }

        Role.RoleBuilder role = Role.builder();

        role.id( roleResponse.id() );
        if ( roleResponse.name() != null ) {
            role.name( Enum.valueOf( RoleName.class, roleResponse.name() ) );
        }

        return role.build();
    }
}
