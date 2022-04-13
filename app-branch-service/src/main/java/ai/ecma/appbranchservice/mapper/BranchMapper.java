package ai.ecma.appbranchservice.mapper;

import ai.ecma.lib.entity.Branch;
import ai.ecma.lib.payload.resp.BranchRespDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

/**
 * @author Murtazayev Muhammad
 * @since 22.01.2022
 */
@Mapper(componentModel = "spring")
public interface BranchMapper {
    @Mapping(target = "addressId", source = "address.id")
    @Mapping(target = "lat", source = "address.lat")
    @Mapping(target = "lon", source = "address.lon")
    BranchRespDto toBranchRespDto(Branch branch);
}
