package ai.ecma.lib.entity;

import ai.ecma.lib.entity.template.AbsLong;
import lombok.*;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.*;

/**
 * @author Murtazayev Muhammad
 * @since 14.01.2022
 */
@Entity
@Table(name = "district")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Where(clause = "deleted=false")
@SQLDelete(sql = "update district set deleted = false where id = ?")
public class District extends AbsLong {
    @Column(name = "name", nullable = false)
    private String name;

    @ManyToOne(optional = false)
    @JoinColumn(name = "region_id")
    private Region region;
}
