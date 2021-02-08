package com.github.client.spring.load;

import com.github.client.utils.AppConfig;
import com.github.client.model.bo.ConfigRequest;
import com.github.client.model.bo.ConfigResponse;
import com.github.client.rpc.ConfigClient;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @author hangs.zhang
 * @date 2020/07/19 21:55
 * *****************
 * function:
 */
@Component
public class RemoteConfigLoader {

    @Resource
    private ConfigClient configClient;

    public boolean checkUpdate(String dataId, Integer version) {
        configClient.checkUpdate(generateConfigRequest(dataId, version));
        return false;
    }

    /**
     * 获取最新配置
     */
    public ConfigResponse getConfig(String dataId) {
        return configClient.getConfig(generateConfigRequest(dataId, null));
    }

    /**
     * 获取指定版本的配置
     */
    public ConfigResponse getConfig(String dataId, Integer version) {
        return configClient.getConfig(generateConfigRequest(dataId, version));
    }

    private ConfigRequest generateConfigRequest(String dataId, Integer version) {
        ConfigRequest configRequest = new ConfigRequest();
        configRequest.setAppName(AppConfig.getName());
        configRequest.setAppToken(AppConfig.getToken());
        configRequest.setDataId(dataId);
        configRequest.setVersion(version);
        return configRequest;
    }

}