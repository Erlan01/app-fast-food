package ai.ecma.appbranchservice.controller;

import ai.ecma.appbranchservice.service.RegionService;
import ai.ecma.lib.entity.Region;
import ai.ecma.lib.payload.ApiResult;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * This class not documented :(
 *
 * @author Muhammad Mo'minov
 * @since 11.02.2022
 */
@RestController
@RequiredArgsConstructor
public class RegionControllerImpl implements RegionController {
    private final RegionService regionService;

    @Override
    public ApiResult<List<Region>> getRegions() {
        return regionService.getAll();
    }
}
