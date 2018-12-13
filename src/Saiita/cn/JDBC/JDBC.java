package Saiita.cn.JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class JDBC {
	public static Log logger = LogFactory.getLog(JDBC.class);
	// MySQL
	String database = "saiita.cn";
	//String utf8 = "&useUnicode=true&characterEncoding=utf8&autoReconnect=true&useSSL=false";
	String utf8 = "?useUnicode=true&characterEncoding=utf8";
	private String url = "jdbc:mysql://39.105.51.6:3306/" + database+utf8;
	private String Ubuntu = "jdbc:mysql://localhost:3306/" + database+utf8;
	private String username = "saiita";
	private String UbuntuPwd = "saiita";
	private String password = "IMPvNaBipm0RBEhC";
	Connection conn;
	public Connection getConnection() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (Exception e) {
			logger.error(e);
		}
		try {
			conn = DriverManager.getConnection(url, username, password);
			logger.info("连接成功");
		} catch (SQLException e) {
			try {
				conn = DriverManager.getConnection(Ubuntu, username, UbuntuPwd);
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				logger.error(e1);
			}
		}
		return conn;
	}
}
