package ai.ecma.lib.entity;

import ai.ecma.lib.entity.template.AbsLong;
import ai.ecma.lib.enums.PermissionEnum;
import ai.ecma.lib.enums.RoleTypeEnum;
import lombok.*;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.util.Set;

/**
 * @author Murtazayev Muhammad
 * @since 14.01.2022
 */
@Entity
@Table(name = "roles")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Where(clause = "deleted=false")
@SQLDelete(sql = "update roles set deleted = false where id = ?")
public class Role extends AbsLong {
    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "role_type", nullable = false)
    @Enumerated(EnumType.STRING)
    private RoleTypeEnum roleType;
}
