package ai.ecma.lib.entity;

import ai.ecma.lib.entity.template.AbsLong;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "delivery_tariff")
@SQLDelete(sql = "update delivery_tariff set deleted=true where id=?")
@Where(clause = "deleted=false")
public class DeliveryTariff extends AbsLong {

    @Column(name = "distance", nullable = false)
    private Double distance;

    @Column(name = "price", nullable = false)
    private Double price;

    @Column(name = "is_minimum")
    private boolean isMinimum;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "branch_id")
    private Branch branch;
}
// 4 km 5000 so'm || true
// 2 km 2000 so'm
// 11000 so'm
