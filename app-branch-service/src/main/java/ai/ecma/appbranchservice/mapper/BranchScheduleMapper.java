package ai.ecma.appbranchservice.mapper;

import ai.ecma.lib.entity.BranchSchedule;
import ai.ecma.lib.payload.resp.BranchScheduleRespDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

/**
 * @author Murtazayev Muhammad
 * @since 22.01.2022
 */
@Mapper(componentModel = "spring")
public interface BranchScheduleMapper {
    @Mapping(target = "branchId", source = "branch.id")
    BranchScheduleRespDto toBranchScheduleRespDto(BranchSchedule schedule);
}
