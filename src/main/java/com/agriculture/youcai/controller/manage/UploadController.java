package com.agriculture.youcai.controller.manage;

import com.agriculture.youcai.enums.ResultEnum;
import com.agriculture.youcai.exception.YoucaiException;
import com.agriculture.youcai.utils.ResultVOUtils;
import com.agriculture.youcai.vo.ResultVO;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.util.UUID;

@RestController
@RequestMapping("/manage/upload")
public class UploadController {

    @Value("${img.location}")
    private String location;

    @PostMapping("/image")
    public ResultVO<String> image(@RequestParam("upload_file") MultipartFile file) throws IOException {
        if (file.isEmpty() || StringUtils.isEmpty(file.getOriginalFilename())) {
            throw new YoucaiException(ResultEnum.MANAGE_UPLOAD_IMAGE_EMPTY);
        }
        File directory = new File(location);
        if (!directory.exists()) {
            directory.mkdirs();
        }
        FileInputStream fileInputStream = (FileInputStream) file.getInputStream();
        String fileName = UUID.randomUUID() + ".png";
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(location + File.separator + fileName));
        byte[] bs = new byte[1024];
        int len;
        while ((len = fileInputStream.read(bs)) != -1) {
            bos.write(bs, 0, len);
        }
        bos.flush();
        bos.close();
        return ResultVOUtils.success(fileName);
    }

}
