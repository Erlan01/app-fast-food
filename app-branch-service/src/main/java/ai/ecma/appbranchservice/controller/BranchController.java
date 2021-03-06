package ai.ecma.appbranchservice.controller;

import ai.ecma.lib.payload.ApiResult;
import ai.ecma.lib.payload.CustomPage;
import ai.ecma.lib.payload.req.BranchReqDto;
import ai.ecma.lib.payload.resp.BranchRespDto;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import static ai.ecma.appbranchservice.utils.AppConstant.*;

/**
 * @author Murtazayev Muhammad
 * @since 22.01.2022
 */
@RequestMapping(BranchController.BRANCH_CONTROLLER)
public interface BranchController {
    String BRANCH_CONTROLLER = BASE_PATH + "/branch";

    @GetMapping
    ApiResult<CustomPage<BranchRespDto>> get(@RequestParam(name = "page", defaultValue = DEFAULT_PAGE_NUMBER, required = false) Integer page,
                                             @RequestParam(name = "size", defaultValue = DEFAULT_PAGE_SIZE, required = false) Integer size);

    @GetMapping("/region/{regionId}")
    ApiResult<CustomPage<BranchRespDto>> getByRegion(@RequestParam(name = "page", defaultValue = DEFAULT_PAGE_NUMBER, required = false) Integer page,
                                                     @RequestParam(name = "size", defaultValue = DEFAULT_PAGE_SIZE, required = false) Integer size,
                                                     @PathVariable Long regionId);

    @GetMapping("/district/{districtId}")
    ApiResult<CustomPage<BranchRespDto>> getByDistrict(@RequestParam(name = "page", defaultValue = DEFAULT_PAGE_NUMBER, required = false) Integer page,
                                                       @RequestParam(name = "size", defaultValue = DEFAULT_PAGE_SIZE, required = false) Integer size,
                                                       @PathVariable Long districtId);

    @GetMapping("/nearly")
    ApiResult<BranchRespDto> getNearly(@RequestParam(name = "lat") Double lat,
                                       @RequestParam(name = "lon") Double lon);

    @GetMapping("/{id}")
    ApiResult<BranchRespDto> get(@PathVariable Long id);

    @PostMapping("/create")
    ApiResult<?> create(@RequestBody @Valid BranchReqDto dto);

    @PutMapping("/edit/{id}")
    ApiResult<?> edit(@PathVariable Long id, @RequestBody @Valid BranchReqDto dto);

    @DeleteMapping("/delete/{id}")
    ApiResult<?> delete(@PathVariable Long id);
}
