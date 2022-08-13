package ai.ecma.lib.entity;

import ai.ecma.lib.entity.template.AbsUUID;
import ai.ecma.lib.enums.OrderRateEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "order_rate")
@SQLDelete(sql = "update order_rate set deleted=true where id=?")
@Where(clause = "deleted=false")
public class OrderRate extends AbsUUID {

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "rate", nullable = false)
    private Integer rate;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "order_id")
    private Order order;

    @Column(name = "comment")
    private String comment;

    @OneToOne(optional = false)
    @JoinColumn(name = "photo_id")
    private Attachment photo;

    @Column(name = "is_defect")
    private boolean isDefect;

    @Column(name = "order_rate")
    @Enumerated(EnumType.STRING)
    private OrderRateEnum orderRate;


}
