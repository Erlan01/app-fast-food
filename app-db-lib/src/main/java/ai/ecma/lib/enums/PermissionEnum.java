package ai.ecma.lib.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author Murtazayev Muhammad
 * @since 14.01.2022
 */
@Getter
@AllArgsConstructor
public enum PermissionEnum {
    ADD_PRODUCT(RoleTypeEnum.SYSTEM_ADMIN),
    ADD_PROMOTION(RoleTypeEnum.SYSTEM_ADMIN),
    ADD_STAFF(RoleTypeEnum.SYSTEM_ADMIN),

    CAN_ADD_USER(RoleTypeEnum.SYSTEM_ADMIN),
    TEST(RoleTypeEnum.OTHER),

    OPERATOR_PERMISSION(RoleTypeEnum.OPERATOR),
    COURIER_PERMISSION(RoleTypeEnum.COURIER),

    ORDER_TO_PROCESS(RoleTypeEnum.OPERATOR),
    ORDER_TO_READY(RoleTypeEnum.COOK),
    ORDER_TO_WAY(RoleTypeEnum.COURIER)


    ;

    private RoleTypeEnum roleType;
}
