package server;

import java.util.ArrayList;
import java.util.List;


public class ChatManager {
//	Vector<ChatSocket> vector=new Vector<ChatSocket>();
	
	 List<ChatSocket>  lists=new ArrayList<>();
	
//	 private static class ChatManagerHolder{
//		 private static final ChatManager cm=new ChatManager();
//	 }
	public static ChatManager getInstance(){
		return  new ChatManager();
	}
	
	public void add(ChatSocket cs){
//		vector.add(cs);
		lists.add(cs);
		System.out.println("添加成功:"+lists.size());
	}
	
	//发给除自己我的人
	public void publish(ChatSocket cs,String out){
		for(int i=0;i<lists.size();i++){
			ChatSocket csChatSocket=lists.get(i);
			if(!cs.equals(csChatSocket)){
				csChatSocket.out(out);
			}
		}
	}
	
	//发给所有人
	public void publishAll(String out){
		for(int i=0;i<lists.size();i++){
			ChatSocket csChatSocket=lists.get(i);
			csChatSocket.out(out);
		}
	}
}
 