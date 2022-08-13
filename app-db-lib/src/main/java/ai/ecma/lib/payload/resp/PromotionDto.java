package ai.ecma.lib.payload.resp;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

/**
 * @author Murtazayev Muhammad
 * @since 27.01.2022
 */

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class PromotionDto {
    private SimplePromotionDto simplePromotionDto;
    private DeliveryPromotionDto deliveryPromotionDto;
    private QuantityPromotionDto quantityPromotionDto;
    private List<GroupPromotionDto> groupPromotionsDto;
}
