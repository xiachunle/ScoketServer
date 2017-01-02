package server;

import util.JdbcUtil;

public class SQLServerConnect extends Thread {
	
	@SuppressWarnings("static-access")
	@Override
	public void run() {
			JdbcUtil.getInstance().ConnectSql();
	}
}
