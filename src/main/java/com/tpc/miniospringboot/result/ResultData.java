package com.tpc.miniospringboot.result;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
public class ResultData<T> {
    public static final Integer SUCCESS_CODE = 200;
    public static final Integer FAIL_CODE = 4000;
    public static final String SUCCESS_MESSAGE = "操作成功";
    public static final String FAIL_MESSAGE = "操作失败";

    /**
     * 返回状态码
     */
    private Integer code;
    /**
     * 返回信息
     */
    @Setter
    @Getter
    private String message;

    /**
     * 返回数据
     */
    @Getter
    @Setter
    private T data;


    public ResultData() {

    }

    public static <T> ResultData<T> success() {
        ResultData<T> resultUtil = new ResultData<>();
        resultUtil.setCode(SUCCESS_CODE);
        resultUtil.setMessage(SUCCESS_MESSAGE);
        return resultUtil;
    }

    public static <T> ResultData<T> success(T data) {
        ResultData<T> resultUtil = success();
        resultUtil.setData(data);
        return resultUtil;
    }

    public static <T> ResultData<T> success(String message, T data) {
        ResultData<T> resultUtil = success();
        resultUtil.setMessage(message);
        resultUtil.setData(data);
        return resultUtil;
    }

    public static <T> ResultData<T> success(Integer code, String message, T data) {
        ResultData<T> resultUtil = new ResultData<>();
        resultUtil.setCode(code);
        resultUtil.setMessage(message);
        resultUtil.setData(data);
        return resultUtil;
    }

    public static <T> ResultData<T> success(Integer code, String message,Integer count, T data) {
        ResultData<T> resultUtil = new ResultData<>();
        resultUtil.setCode(code);
        resultUtil.setMessage(message);
        resultUtil.setData(data);
        return resultUtil;
    }

    public static <T> ResultData<T> fail() {
        ResultData<T> resultUtil = new ResultData<>();
        resultUtil.setCode(FAIL_CODE);
        resultUtil.setMessage(FAIL_MESSAGE);
        return resultUtil;
    }

    public static <T> ResultData<T> fail(T data) {
        ResultData<T> resultUtil = fail();
        resultUtil.setData(data);
        return resultUtil;
    }

    public static <T> ResultData<T> fail(String message, T data) {
        ResultData<T> resultUtil = fail();
        resultUtil.setMessage(message);
        resultUtil.setData(data);
        return resultUtil;
    }

    public static <T> ResultData<T> fail(Integer code, String message) {
        ResultData<T> resultUtil = fail();
        resultUtil.setCode(code);
        resultUtil.setMessage(message);
        return resultUtil;
    }

    public static <T> ResultData<T> fail(Integer code, String message, T data) {
        ResultData<T> resultUtil = new ResultData<>();
        resultUtil.setCode(code);
        resultUtil.setMessage(message);
        resultUtil.setData(data);
        return resultUtil;
    }

    public void setCode(int code){
        this.code = code;
    }
    public int getCode(){
        return this.code;
    }

}
