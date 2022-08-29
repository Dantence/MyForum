package com.yyw.community.mycommunity.controller;

import com.yyw.community.mycommunity.dto.FileDTO;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

/**
 * @author Dantence
 * @date 2022/7/21
 */
@Controller
public class FileController {
    public final static String UPLOAD_PATH_PREFIX = "src/main/resources/static";
    @Value("${pro.uploadPath}")
    private String uploadPath;
    @RequestMapping("/file/upload")
    @ResponseBody
    public FileDTO upload(@RequestParam("editormd-image-file") MultipartFile file, HttpServletRequest request) {
        FileDTO fileDTO = new FileDTO();
        if(!file.isEmpty()){
            String fileName = file.getOriginalFilename();
            String newFileName = UUID.randomUUID().toString().replaceAll("-", "") + fileName.substring(fileName.lastIndexOf("."));
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
            String format = simpleDateFormat.format(new Date());
            File readPath = new File(UPLOAD_PATH_PREFIX + uploadPath + File.separator + format);
            if (!readPath.isDirectory()) {
                // 创建文件夹
                readPath.mkdirs();
            }
            File f = new File(readPath.getAbsolutePath() + File.separator + newFileName);
            try {
                file.transferTo(f);
                String url = getUploadPath(request, format + "/" + newFileName);
                fileDTO.setSuccess(1);
                fileDTO.setUrl(url);
            } catch (IOException e) {
                fileDTO.setSuccess(0);
                fileDTO.setMessage("上传失败");
            }
        } else {
            fileDTO.setSuccess(0);
            fileDTO.setMessage("文件不能为空");
        }

        return fileDTO;
    }
    public String getUploadPath(HttpServletRequest request, String fileName) {
        return request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + uploadPath + "/" + fileName;
    }
}
