package ai.ecma.lib.entity;

import ai.ecma.lib.entity.template.AbsUUID;
import ai.ecma.lib.enums.PaymentStatusEnum;
import lombok.*;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "order_payment")
@SQLDelete(sql = "update order_payment set deleted=true where id=?")
@Where(clause = "deleted=false")
public class OrderPayment extends AbsUUID {

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "order_id")
    private Order order;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "pay_type_id")
    private PayType payType;

    @Column(name = "total_sum", nullable = false)
    private Double totalSum;

    @Column(name = "payment_status")
    @Enumerated(EnumType.STRING)
    private PaymentStatusEnum paymentStatus;

    private String chargeId;

    public OrderPayment(Order order, PayType payType, Double totalSum, PaymentStatusEnum paymentStatus) {
        this.order = order;
        this.payType = payType;
        this.totalSum = totalSum;
        this.paymentStatus = paymentStatus;
    }
}
