package server;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class SimpleServer {

	public static void main(String[] args) {
		 InetAddress addr;
		 try {
			addr=InetAddress.getLocalHost();
			String ip=addr.getHostAddress();
			System.out.println(ip);
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		new ServerListener().start();
		new SQLServerConnect().start();//连接数据库
	}

}
