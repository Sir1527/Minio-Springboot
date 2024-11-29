package com.tpc.miniospringboot.controller;

import com.tpc.miniospringboot.result.ResultData;
import com.tpc.miniospringboot.utils.MinioUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/minio")
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
}
