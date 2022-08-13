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
@Entity(name = "simple_promotion")
@SQLDelete(sql = "update simple_promotion set deleted=true where id=?")
@Where(clause = "deleted=false")
public class SimplePromotion extends AbsLong {

    @Column(name = "price", nullable = false)
    private Double price;

    @Column(name = "percent", nullable = false)
    private Double percent;

    @OneToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "parent_id")
    private Promotion promotion;
}
