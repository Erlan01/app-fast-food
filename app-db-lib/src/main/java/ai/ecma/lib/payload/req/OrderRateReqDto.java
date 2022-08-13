package ai.ecma.lib.payload.req;

import ai.ecma.lib.enums.OrderRateEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.UUID;

/**
 * @AUTHOR: userdev
 * @DONE_ON: 2022/02/16
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class OrderRateReqDto {

    @NotBlank
    private String title;

    @NotNull
    @Size(min = 0, max = 5)
    private Integer rate;

    @NotNull
    private UUID orderId;

    private String comment;

    private Long attachmentId;

    private boolean isDefect;

    @NotNull
    private OrderRateEnum orderRate;
}
