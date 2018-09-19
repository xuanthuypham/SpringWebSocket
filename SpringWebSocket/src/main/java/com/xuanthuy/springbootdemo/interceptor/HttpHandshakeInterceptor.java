package com.xuanthuy.springbootdemo.interceptor;


import java.util.Map;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.http.server.ServletServerHttpRequest;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.server.HandshakeInterceptor;

@Component
public class HttpHandshakeInterceptor implements HandshakeInterceptor {

	private static final Logger LOGGER = LoggerFactory.getLogger(HttpHandshakeInterceptor.class);
	
	@Override
	public void afterHandshake(ServerHttpRequest arg0, ServerHttpResponse arg1, WebSocketHandler arg2, Exception arg3) {
		// TODO Auto-generated method stub
		LOGGER.info("Call after Handshake");
	}

	@Override
	public boolean beforeHandshake(ServerHttpRequest request, ServerHttpResponse response, WebSocketHandler wsh,
			Map<String, Object> object) throws Exception {
		// TODO Auto-generated method stub
		LOGGER.info("Call before Handshake");
		if(request instanceof ServletServerHttpRequest) {
			ServletServerHttpRequest serverHttpRequest = (ServletServerHttpRequest) request;
			HttpSession session = serverHttpRequest.getServletRequest().getSession();
			object.put("sessionId", session.getId());
		}
		return true;
	}

}
