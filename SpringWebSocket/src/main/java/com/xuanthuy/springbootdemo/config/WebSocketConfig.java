package com.xuanthuy.springbootdemo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

import com.xuanthuy.springbootdemo.interceptor.HttpHandshakeInterceptor;

@Configuration
@EnableWebSocketMessageBroker  //Hay bat Websocket server
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer {
	
	
	@Autowired
	private HttpHandshakeInterceptor handshakeInterceptor;
	
	@Override
	public void configureMessageBroker(MessageBrokerRegistry registry) {
		// TODO Auto-generated method stub
		registry.setApplicationDestinationPrefixes("/app");
		registry.enableSimpleBroker("/topic");
	}

	@Override
	public void registerStompEndpoints(StompEndpointRegistry registry) {
		// TODO Auto-generated method stub
		registry.addEndpoint("/ws").withSockJS().setInterceptors(handshakeInterceptor);
	}


	
	
}
