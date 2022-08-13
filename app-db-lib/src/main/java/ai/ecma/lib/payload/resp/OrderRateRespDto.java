package ai.ecma.lib.payload.resp;

import ai.ecma.lib.entity.Attachment;
import ai.ecma.lib.entity.Order;
import ai.ecma.lib.enums.OrderRateEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

/**
 * @AUTHOR: userdev
 * @DONE_ON: 2022/02/16
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class OrderRateRespDto {

    private UUID id;
    private String title;
    private Integer rate;
    private UUID orderId;
    private String comment;
    private Long attachmentId;
    private boolean isDefect;
    private OrderRateEnum orderRate;

}
