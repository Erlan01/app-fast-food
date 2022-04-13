package ai.ecma.appbranchservice.controller;

import ai.ecma.appbranchservice.utils.AppConstant;
import ai.ecma.lib.entity.Region;
import ai.ecma.lib.payload.ApiResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * This interface not documented :(
 *
 * @author Muhammad Mo'minov
 * @since 11.02.2022
 */
@RequestMapping(RegionController.REGION_CONTROLLER)
public interface RegionController {
    String REGION_CONTROLLER = AppConstant.BASE_PATH + "/region";

    @GetMapping
    ApiResult<List<Region>> getRegions();

}
