package ai.ecma.lib.payload.req;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import java.util.UUID;

/**
 * @author Murtazayev Muhammad
 * @since 23.01.2022
 */
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ProductDiscountDto {
    @NotNull(message = "{PRODUCT_REQUIRED}")
    private UUID productId;

    @NotNull(message = "{DISCOUNT_REQUIRED}")
    private Long discountId;
}
