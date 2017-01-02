package server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;



public class ServerListener extends Thread {
	public static final int PORT=9527;
	private ChatManager  chatManager=ChatManager.getInstance();
	
	
	@Override
	public void run() {
		try {
			
			@SuppressWarnings("resource")
			ServerSocket serverSocket=new ServerSocket(PORT);
			while(true){
				Socket socket=serverSocket.accept();
				System.out.println("有客户端连接到本机的9527端口");
				ChatSocket cs=new ChatSocket(socket);
				cs.start();
				chatManager.add(cs);
				System.out.println("服务器反馈:有客户端连接到服务器");
				chatManager.publishAll("服务器反馈:有客户端连接到服务器");
				
				
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	

}
