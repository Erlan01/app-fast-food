package ai.ecma.lib.entity;

import ai.ecma.lib.entity.template.AbsUUID;
import lombok.*;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.*;

/**
 * @author Murtazayev Muhammad
 * @since 14.01.2022
 */
@Entity
@Table(name = "address")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Where(clause = "deleted=false")
@SQLDelete(sql = "update address set deleted = false where id = ?")
public class Address extends AbsUUID {
    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "lat")
    private Double lat;

    @Column(name = "lon")
    private Double lon;

    @ManyToOne(optional = false)
    @JoinColumn(name = "district_id")
    private District district;
}
