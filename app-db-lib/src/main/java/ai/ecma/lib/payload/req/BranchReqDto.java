package ai.ecma.lib.payload.req;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.UUID;

/**
 * @author Murtazayev Muhammad
 * @since 22.01.2022
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BranchReqDto {
    @NotBlank(message = "{BRANCH_NAME_REQUIRED}")
    private String name;

    private UUID addressId;

    private String addressName;

    private Double addressLat;

    private Double addressLon;

    private Long districtId;

    @NotNull(message = "{DELIVERY_DISTANCE_REQUIRED}")
    private Integer maxDeliveryDistance;

    @NotNull(message = "{DELIVERY_TIME_REQUIRED}")
    private Integer maxDeliveryTime;

    private boolean autoDistribution;

    private boolean active;
}
