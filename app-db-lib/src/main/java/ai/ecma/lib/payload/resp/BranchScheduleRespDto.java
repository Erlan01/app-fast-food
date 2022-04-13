package ai.ecma.lib.payload.resp;

import ai.ecma.lib.enums.WeekdaysNameEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Time;

/**
 * @author Murtazayev Muhammad
 * @since 23.01.2022
 */
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class BranchScheduleRespDto {
    private Long id;
    private WeekdaysNameEnum weekdaysNameEnum;
    private Time startTime;
    private Time endTime;
    private Long branchId;
}
