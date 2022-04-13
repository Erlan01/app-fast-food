package ai.ecma.lib.entity;

import ai.ecma.lib.entity.template.AbsUUID;
import ai.ecma.lib.enums.OrderStatusEnum;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder(setterPrefix = "set")
@Entity(name = "orders")
@SQLDelete(sql = "update orders set deleted=true where id=?")
@Where(clause = "deleted=false")
public class Order extends AbsUUID {

    @Column(name = "serial_number", nullable = false, unique = true)
    private String serialNumber;

    @Column(name = "receive_time")
    private Timestamp receiveTime;

    @Column(name = "ready_time")
    private Integer readyTime;

    @OneToOne
    @JoinColumn(name = "branch_id")
    private Branch branch;

    @OneToOne
    @JoinColumn(name = "address_id")
    private Address address;

    @ManyToOne
    @JoinColumn(name = "courier_id")
    private User courier;

    @Column(name = "delivery_price")
    private Double deliveryPrice;

    @Column(name = "total_sum", nullable = false)
    private Double totalSum;

    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    private OrderStatusEnum status;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "client_id")
    private User client;

    @Column(name = "is_delivery")
    private boolean isDelivery;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "operator_id")
    private User operator;

    @Column(name = "description")
    private String description;

    @ManyToOne(optional = true, fetch = FetchType.LAZY)
    @JoinColumn(name = "pay_type_id")
    private PayType payType;
}
