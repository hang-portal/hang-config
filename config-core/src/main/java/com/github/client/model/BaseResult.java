package com.github.client.model;

import com.github.client.enums.ResultEnum;
import lombok.Data;

/**
 * @author hangs.zhang
 * @date 2018/8/27
 * *********************
 * function:
 */
@Data
public class BaseResult<T> {

    private Integer code;

    private String message;

    private T data;

    public static <T> BaseResult<T> success(T obj) {
        BaseResult<T> baseRes = new BaseResult<>();
        baseRes.setCode(ResultEnum.SUCCESS.getCode());
        baseRes.setMessage(ResultEnum.SUCCESS.getMessage());
        baseRes.setData(obj);
        return baseRes;
    }

    public static <T> BaseResult<T> success() {
        return success(null);
    }

    public static <T> BaseResult<T> error(Integer code, String msg) {
        BaseResult<T> baseRes = new BaseResult<>();
        baseRes.setCode(code);
        baseRes.setMessage(msg);
        baseRes.setData(null);
        return baseRes;
    }

    public static <T> BaseResult<T> error(ResultEnum resultEnum) {
        BaseResult<T> baseRes = new BaseResult<>();
        baseRes.setCode(resultEnum.getCode());
        baseRes.setMessage(resultEnum.getMessage());
        baseRes.setData(null);
        return baseRes;
    }

}
