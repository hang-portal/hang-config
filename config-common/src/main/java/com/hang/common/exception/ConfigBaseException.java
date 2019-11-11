package com.hang.common.exception;

import com.hang.common.enums.ResultEnum;
import lombok.Getter;

/**
 * @author hangs.zhang
 * @date 2018/8/27
 * *********************
 * function:
 */
@Getter
public class ConfigBaseException extends RuntimeException {

    protected Integer code;

    public ConfigBaseException(ResultEnum resultEnum) {
        super(resultEnum.getMessage());
        this.code = resultEnum.getCode();
    }

    public ConfigBaseException(String message) {
        super(message);
    }

    public ConfigBaseException(Integer code) {
        this.code = code;
    }

    public ConfigBaseException(String message, Throwable e) {
        super(message, e);
    }

}
