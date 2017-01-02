package util;

import java.sql.Connection;
import java.sql.DriverManager;

public class JdbcUtil {
	public static String server="127.0.0.1";
	public static int port=3306;
	public static String sqlUsername="root";
	public static String sqlPassword="";
	public static String sqlCharset="UTF-8";
	public static String sqlType="com.mysql.jdbc.Driver";
	public static String sqlDataBaseName="socketchat";
	
	public static String url="jdbc:mysql:"
			+ "//"+server+":"+port+"/"+sqlDataBaseName+"?user="+sqlUsername+"&passord="+sqlPassword+
			 "&useUnicode=true&characterEncoding="+sqlCharset;
	
	public static JdbcUtil getInstance(){
		return new JdbcUtil();
	}
	
	private  static Connection conn=null;
	public static void ConnectSql(){
		try {
			Class.forName(sqlType);
			System.out.println("加载驱动成功");
			conn=DriverManager.getConnection(url);
				
			System.out.println(conn);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
