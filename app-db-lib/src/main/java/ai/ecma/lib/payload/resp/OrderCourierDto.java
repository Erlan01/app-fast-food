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
public class OrderCourierDto {
    private UUID id;
    private String name;
    private String phoneNumber;
}
