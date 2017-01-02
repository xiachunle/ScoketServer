package server;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.net.Socket;

public class ChatSocket extends Thread {
		Socket socket;
		BufferedWriter bw;
		BufferedReader br;
		public ChatSocket(Socket s){
			this.socket=s;
			
			try {
				bw=new BufferedWriter(new OutputStreamWriter(socket.getOutputStream(),"utf-8"));
				br=new BufferedReader(new InputStreamReader(socket.getInputStream(), "utf-8"));
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
		}
		/**
		 * 发送消息
		 * @param out
		 */
		public void out(String out){
			System.out.println("即将发送:"+out);
			try {
				bw.write(out+"\n");
				bw.flush();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		@Override
		public void run() {
				try {
					String line=null;
					while((line=br.readLine())!=null){
						System.out.println("客户端发来数据:"+line);
						if(line.contains("username")&&line.contains("password")){
							//检测用户数据并将检测结果通知当前socket
						}
						ChatManager.getInstance().publish(this, line);//发给其余的客户端
					}
					br.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
		
}
