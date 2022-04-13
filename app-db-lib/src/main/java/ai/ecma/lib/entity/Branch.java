package ai.ecma.lib.entity;


import ai.ecma.lib.entity.template.AbsLong;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "branch")
@SQLDelete(sql = "update branch set deleted=true where id=?")
@Where(clause = "deleted=false")
public class Branch extends AbsLong {

    @Column(name = "name", nullable = false)
    private String name;

    @OneToOne
    @JoinColumn(name = "address_id")
    private Address address;

    @Column(name = "max_delivery_distance", nullable = false)
    private Integer maxDeliveryDistance;

    @Column(name = "max_delivery_time", nullable = false)
    private Integer maxDeliveryTime;

    @Column(name = "auto_distribution")
    private boolean autoDistribution;

    @Column(name = "active")
    private boolean active;
}
