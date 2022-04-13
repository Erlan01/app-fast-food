package ai.ecma.appbranchservice.controller;

import ai.ecma.appbranchservice.payload.ResponseFileDto;
import ai.ecma.appbranchservice.utils.AppConstant;
import ai.ecma.lib.entity.Attachment;
import ai.ecma.lib.payload.ApiResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@RequestMapping(AttachmentController.ATTACHMENT_CONTROLLER)
public interface AttachmentController {

    String ATTACHMENT_CONTROLLER = AppConstant.BASE_PATH + "/attachment";

    @PostMapping("/upload")
    ApiResult<?> upload(MultipartHttpServletRequest request) throws IOException;

    @GetMapping("/download/{id}")
    void download(@PathVariable(value = "id") Long id, HttpServletResponse response);

    @GetMapping()
    ApiResult<List<ResponseFileDto>> getListFiles();

    @GetMapping("{id}")
    ApiResult<Attachment> get(@PathVariable Long id);

}
