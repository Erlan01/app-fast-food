package ai.ecma.lib.payload.resp;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

/**
 * @author Murtazayev Muhammad
 * @since 22.01.2022
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BranchRespDto {
    private Long id;
    private UUID addressId;
    private Integer maxDeliveryDistance;
    private Integer maxDeliveryTime;
    private boolean autoDistribution;
    private boolean active;
}
