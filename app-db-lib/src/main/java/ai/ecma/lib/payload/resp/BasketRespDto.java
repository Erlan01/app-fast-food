package ai.ecma.lib.payload.resp;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

/**
 * @author Murtazayev Muhammad
 * @since 26.01.2022
 */
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class BasketRespDto {
    private List<OrderProductDto> orderProductDto;

    private Double totalSum;  // jami hisoblangan summa
}
