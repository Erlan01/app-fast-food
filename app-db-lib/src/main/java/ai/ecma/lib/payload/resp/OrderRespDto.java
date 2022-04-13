package ai.ecma.lib.payload.resp;

import ai.ecma.lib.enums.PayTypeEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Timestamp;
import java.util.List;
import java.util.UUID;

/**
 * @author Murtazayev Muhammad
 * @since 27.01.2022
 */
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class OrderRespDto {
    private UUID orderId;
    private Timestamp receiveTime;
    private Long branchId;
    private String branchName;
    private OrderAddressDto address;
    private OrderCourierDto courier;
    private List<OrderProductDto> products;
    private String comment;
    private Double deliveryPrice;
    private Double totalSum;
    private PayTypeEnum payType;
}
