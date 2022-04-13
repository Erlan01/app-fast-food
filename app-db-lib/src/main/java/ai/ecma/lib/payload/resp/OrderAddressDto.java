package ai.ecma.lib.payload.resp;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

/**
 * @author Murtazayev Muhammad
 * @since 27.01.2022
 */
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter

public class OrderAddressDto {
    private UUID id;
    private String addressName;
    private Double addressLat;
    private Double addressLon;
}
