package ai.ecma.lib.payload.req;

import ai.ecma.lib.entity.Discount;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.UUID;

/**
 * @author Murtazayev Muhammad
 * @since 23.01.2022
 */
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class ProductReqDto {
    @NotBlank(message = "{PRODUCT_NAME_REQUIRED}")
    private String name;

    @NotNull(message = "{PRODUCT_PRICE_REQUIRED}")
    private Double price;

    private Long photoId;

    @NotNull(message = "{CATEGORY_REQUIRED}")
    private Long categoryId;

    private Long discountId;

    private String description;

    private boolean active;
}
