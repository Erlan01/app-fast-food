package ai.ecma.lib.entity;

import ai.ecma.lib.entity.template.AbsUUID;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.util.List;

/**
 * @author Murtazayev Muhammad
 * @since 27.01.2022
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder(setterPrefix = "set")
@Entity(name = "order_promotion")
@SQLDelete(sql = "update order_promotion set deleted=true where id=?")
@Where(clause = "deleted=false")
public class OrderPromotion extends AbsUUID {
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "promotion_id")
    private Promotion promotion;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "order_id")
    private Order order;

    @Column(name = "price")
    private Double price;

    @Column(name = "percent")
    private Double percent;
}
