package com.purang.config_client;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
/**
 * 配置更新（/bus/refresh）必须要,还需要配置management.security.enabled=false
 * 安装rabbitmq（mac）：brew install rabbitmq
 * 启动: rabbitmq-server –detached
 * 关闭:rabbitmqctl stop
 * mq管理端口：15672，连接端口：5672
 * @author imac
 *
 */
@SpringBootApplication
@RestController
@EnableEurekaClient
@RefreshScope	
public class ConfigClientApplication 
{
    public static void main( String[] args )
    {
        SpringApplication.run(ConfigClientApplication.class, args);
    }
    
    @Value("${foo}")
    String foo;
    
    @RequestMapping(value="/hi")
    public String hi() {
    		return foo;
    }
}
