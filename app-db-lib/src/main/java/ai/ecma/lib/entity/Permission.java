package ai.ecma.lib.entity;

import ai.ecma.lib.entity.template.AbsLong;
import ai.ecma.lib.enums.PermissionEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

/**
 * This class not documented :(
 *
 * @author Muhammad Mo'minov
 * @since 03.02.2022
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity(name = "Permissions")
public class Permission extends AbsLong {
    @Enumerated(EnumType.STRING)
    private PermissionEnum name;
}
