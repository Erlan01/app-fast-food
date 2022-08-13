package ai.ecma.lib.payload.resp;

import ai.ecma.lib.entity.Discount;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

/**
 * @author Murtazayev Muhammad
 * @since 23.01.2022
 */
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class ProductRespDto {
    private UUID id;
    private String name;
    private Double price;
    private Long photoId;
    private Long categoryId;
    private Long discountId;
    private String description;
    private boolean active;
}
