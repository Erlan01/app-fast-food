package ai.ecma.lib.entity;

import ai.ecma.lib.entity.template.AbsUUID;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;

/**
 * @author Murtazayev Muhammad
 * @since 27.01.2022
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder(setterPrefix = "set")
@Entity(name = "promotion_product")
@SQLDelete(sql = "update promotion_product set deleted=true where id=?")
@Where(clause = "deleted=false")
public class PromotionProduct extends AbsUUID {
    @ManyToOne(fetch = FetchType.LAZY)
    private OrderPromotion orderPromotion;

    @ManyToOne
    private Product product;

    @Column(name = "quantity")
    private Integer quantity;

    @Column(name = "group_number")
    private String groupNumber;
}
