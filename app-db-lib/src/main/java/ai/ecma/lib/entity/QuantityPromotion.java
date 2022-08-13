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
@Entity(name = "quantity_promotion")
@SQLDelete(sql = "update quantity_promotion set deleted=true where id=?")
@Where(clause = "deleted=false")
public class QuantityPromotion extends AbsLong {

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "purchased_product_id")
    private Product purchasedProduct;

    @Column(name = "purchased_count", nullable = false)
    private Integer purchasedCount;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "bonus_product_id")
    private Product bonusProduct;

    @Column(name = "bonus_count", nullable = false)
    private Integer bonusCount;

    @OneToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "parent_id")
    private Promotion promotion;
}
