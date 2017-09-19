package com.dp.intelligentplant.fbox;

import java.io.IOException;

import microsoft.aspnet.signalr.client.ErrorCallback;
import microsoft.aspnet.signalr.client.MessageReceivedHandler;
import microsoft.aspnet.signalr.client.NullLogger;
import microsoft.aspnet.signalr.client.hubs.HubConnection;

import com.dp.intelligentplant.websocket.SignalRWebSocket;
import com.google.gson.JsonElement;

public class SignalRConnectUtil {
	public static HubConnection beginConnect(String url, String token,
			String clientId) {

		HubConnection connection = new HubConnection(url, "at=" + token
				+ "&cid=" + clientId, true, new NullLogger());
		connection.createHubProxy("clienthub");

		connection.connected(new Runnable() {

			@Override
			public void run() {
				
				System.out.println("the signalR is connected...");
//				SignalRTest.isConneted=true;
			}
		});
		connection.error(new ErrorCallback() {

			@Override
			public void onError(Throwable error) {
				
//				SignalRTest.isConneted=false;
				System.out.println("error");
				System.out.println(error.toString());
				if (error != null && error.toString().contains("401")) {
					
				}

			}
		});
		connection.closed(new Runnable() {
			
			@Override
			public void run() {
				System.out.println("the signalR is closed...");
//				SignalRTest.isConneted=false;
				
			}
		});
		connection.received(new MessageReceivedHandler() {

			@Override
			public void onMessageReceived(JsonElement arg0) {
				//if(arg0.getAsJsonObject().get("M").equals("dMonUpdateValue"))
				System.out.println(arg0.toString());
				for (SignalRWebSocket ws : SignalRWebSocket.webSocketSet) {
					try {
						ws.sendMessage(arg0.toString());
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}
		});
		connection.start();
		return connection;
	}

}
