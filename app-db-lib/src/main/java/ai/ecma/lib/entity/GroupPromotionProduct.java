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
@Entity(name = "group_promotion_product")
@SQLDelete(sql = "update group_promotion_product set deleted=true where id=?")
@Where(clause = "deleted=false")
public class GroupPromotionProduct extends AbsLong {

    @Column(name = "name", nullable = false)
    private String name;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "group_promotion_id")
    private GroupPromotion groupPromotion;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id")
    private Product product;

    @Column(name = "quantity", nullable = false)
    private Integer quantity;
}
