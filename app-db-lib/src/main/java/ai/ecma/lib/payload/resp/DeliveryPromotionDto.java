package ai.ecma.lib.payload.resp;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Time;

/**
 * @author Murtazayev Muhammad
 * @since 27.01.2022
 */
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class DeliveryPromotionDto {
    private String name;
    private Time startTime;
    private Time endTime;
}
