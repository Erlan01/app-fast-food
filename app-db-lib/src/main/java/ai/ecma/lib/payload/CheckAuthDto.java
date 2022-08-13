package ai.ecma.lib.payload;

import ai.ecma.lib.enums.PermissionEnum;
import ai.ecma.lib.enums.RoleTypeEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * This class not documented :(
 *
 * @author Muhammad Mo'minov
 * @since 03.02.2022
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class CheckAuthDto {
    private PermissionEnum[] permissions;
    private RoleTypeEnum[] roles;
}
