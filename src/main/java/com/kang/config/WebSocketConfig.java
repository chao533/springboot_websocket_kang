package com.kang.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.server.standard.ServerEndpointExporter;

/**
　 * <p>Title: WebSocketConfig</p> 
　 * <p>Description: 开启websocket的支持</p> 
　 * @author CK 
　 * @date 2020年5月18日
 */
@Configuration  
public class WebSocketConfig {  
    @Bean  
    public ServerEndpointExporter serverEndpointExporter(){  
        return new ServerEndpointExporter();  
    }  
}  
