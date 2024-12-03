package com.tpc.miniospringboot.controller;

import com.tpc.miniospringboot.result.ResultData;
import com.tpc.miniospringboot.utils.MinioUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;

@RestController
@RequestMapping("/minio")
@Slf4j
public class MinioController {

    @Autowired
    MinioUtil minioUtil;

    /**
     * 列出所有的桶
     */
    @RequestMapping(value = "/listBuckets", method = RequestMethod.GET)
    public ResultData listBuckets() throws Exception {
        return ResultData.success(minioUtil.listBuckets());
    }

    @RequestMapping(value = "/listFile", method = RequestMethod.GET)
    public ResultData listFiles (@RequestParam("bucketName") String bucketName) throws Exception {
        return ResultData.success(minioUtil.listFiles(bucketName));
    }

    @PostMapping("/upload")
    public ResultData<String> upload(MultipartFile file) throws Exception {
        log.info("文件上传:{}",file);
        String url = minioUtil.uploadFile(file.getInputStream(),"sky",file.getOriginalFilename());
        return ResultData.success(url);
    }

    /**
     * 文件下载
     *
     * @param bucket 桶名
     * @param objectName 对象名
     * @return 是否成功
     */
    @GetMapping("download")
    public ResultData download(@RequestParam("bucket") String bucket,
                               @RequestParam("objectName") String objectName){
        try {
            InputStream download = minioUtil.download(bucket, objectName);
            return ResultData.success();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
