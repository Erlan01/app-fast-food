package ai.ecma.lib.payload.req;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * @author Murtazayev Muhammad
 * @since 23.01.2022
 */

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class BranchScheduleReqDto {
    @NotBlank(message = "{WEEKDAY_REQUIRED}")
    private String weekDay;

    private String startTime;

    private String endTime;

    @NotNull(message = "{BRANCH_ID_REQUIRED}")
    private Long branchId;
}
