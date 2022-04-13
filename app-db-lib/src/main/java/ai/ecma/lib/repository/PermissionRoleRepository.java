package ai.ecma.lib.repository;

import ai.ecma.lib.entity.PermissionRole;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

/**
 * This interface not documented :(
 *
 * @author Muhammad Mo'minov
 * @since 03.02.2022
 */
public interface PermissionRoleRepository extends JpaRepository<PermissionRole, Long> {
    List<PermissionRole> findAllByRoleId(Long roleId);
}
