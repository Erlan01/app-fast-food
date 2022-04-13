package ai.ecma.lib.payload.resp;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author Murtazayev Muhammad
 * @since 27.01.2022
 */

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class SimplePromotionDto {
    private Long id;
    private String name;
    private Double percent;
}
