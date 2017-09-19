package com.dp.intelligentplant.websocket;

import java.io.IOException;
import java.util.concurrent.CopyOnWriteArraySet;

import javax.websocket.OnClose;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

@ServerEndpoint("/websocket/signalR")
public class SignalRWebSocket {

	//与某个客户端的连接会话，需要通过它来给客户端发送数据
	private Session session;
	
	public static CopyOnWriteArraySet<SignalRWebSocket> webSocketSet = new CopyOnWriteArraySet<SignalRWebSocket>();
	
	@OnOpen
	public void onOpen(Session session) {
		System.out.println("websocket open");
		this.session = session;
		webSocketSet.add(this);
	}
	
	@OnClose
	public void onClose() {
		System.out.println("websocket close");
		webSocketSet.remove(this);
	}
	
	public void sendMessage (String message) throws IOException {
		this.session.getAsyncRemote().sendText(message);
	}
	
}
