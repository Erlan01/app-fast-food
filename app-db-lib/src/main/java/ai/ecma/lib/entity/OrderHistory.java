package ai.ecma.lib.entity;

import ai.ecma.lib.entity.template.AbsUUID;
import ai.ecma.lib.enums.OrderStatusEnum;
import lombok.*;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.sql.Timestamp;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "order_history")
@SQLDelete(sql = "update order_history set deleted=true where id=?")
@Where(clause = "deleted=false")
public class OrderHistory extends AbsUUID {

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "order_id")
    private Order order;

    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    private OrderStatusEnum status;

    @Column(name = "date", nullable = false)
    private Timestamp date;

    @ManyToOne(optional = true, fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;
}
