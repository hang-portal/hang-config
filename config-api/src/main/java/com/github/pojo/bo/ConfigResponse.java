package com.github.pojo.bo;

import com.github.enums.ConfigType;
import lombok.Data;

/**
 * @author hangs.zhang
 * @date 2020/07/19 22:02
 * *****************
 * function:
 */
@Data
public class ConfigResponse extends ConfigInfo {

    private String content;

    private ConfigType configType;

    private Integer version;

}