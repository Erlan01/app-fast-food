package ai.ecma.lib.repository;

import ai.ecma.lib.entity.Role;
import ai.ecma.lib.entity.User;
import ai.ecma.lib.enums.RoleTypeEnum;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * This interface not documented :(
 *
 * @author Muhammad Mo'minov
 * @since 17.01.2022
 */
public interface RoleRepository extends JpaRepository<Role, Long> {

    Optional<Role> findByRoleType(RoleTypeEnum roleType);

//    This is my first commit!

}
