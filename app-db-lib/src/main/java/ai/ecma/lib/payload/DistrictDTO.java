package ai.ecma.lib.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * This class not documented :(
 *
 * @author Muhammad Mo'minov
 * @since 11.02.2022
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class DistrictDTO {
    private Long id;

    private String name;

    private Long regionId;
}
