package ai.ecma.appbranchservice.service;

import ai.ecma.appbranchservice.payload.ResponseFileDto;
import ai.ecma.lib.entity.Attachment;
import ai.ecma.lib.payload.ApiResult;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public interface AttachmentService {

    ApiResult<?> upload(MultipartHttpServletRequest request) throws IOException;

    void download(Long id, HttpServletResponse response);

    ApiResult<List<ResponseFileDto>> getListFiles();

    ApiResult<Attachment> get(Long id);
}
