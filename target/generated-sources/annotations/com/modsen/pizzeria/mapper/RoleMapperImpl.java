package com.modsen.pizzeria.mapper;

import com.modsen.pizzeria.domain.Role;
import com.modsen.pizzeria.domain.RoleName;
import com.modsen.pizzeria.dto.request.RoleRequest;
import com.modsen.pizzeria.dto.response.RoleResponse;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-11-07T14:21:43+0300",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 21.0.1 (Oracle Corporation)"
)
@Component
public class RoleMapperImpl implements RoleMapper {

    @Override
    public RoleResponse toRoleResponse(Role role) {
        if ( role == null ) {
            return null;
        }

        Long id = null;
        String name = null;

        id = role.getId();
        if ( role.getName() != null ) {
            name = role.getName().name();
        }

        RoleResponse roleResponse = new RoleResponse( id, name );

        return roleResponse;
    }

    @Override
    public Role toRole(RoleRequest roleRequest) {
        if ( roleRequest == null ) {
            return null;
        }

        Role.RoleBuilder role = Role.builder();

        if ( roleRequest.name() != null ) {
            role.name( Enum.valueOf( RoleName.class, roleRequest.name() ) );
        }

        return role.build();
    }
}
