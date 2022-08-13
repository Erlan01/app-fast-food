package ai.ecma.lib.entity;

import ai.ecma.lib.entity.template.AbsLong;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.sql.Time;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "delivery_promotion")
@SQLDelete(sql = "update delivery_promotion set deleted=true where id=?")
@Where(clause = "deleted=false")
public class DeliveryPromotion extends AbsLong {

    @Column(name = "price", nullable = false)
    private Double price;

    @Column(name = "start_time")
    private Time startTime;

    @Column(name = "end_time")
    private Time endTime;

    @OneToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "parent_id")
    private Promotion promotion;
}
