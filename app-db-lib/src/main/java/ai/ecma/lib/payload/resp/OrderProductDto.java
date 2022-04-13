package ai.ecma.lib.payload.resp;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

/**
 * @author Murtazayev Muhammad
 * @since 26.01.2022
 */

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class OrderProductDto {
    private UUID productId;

    private Long photoId;

    private String productName;

    private Double price;

    private Integer quantity;
}
