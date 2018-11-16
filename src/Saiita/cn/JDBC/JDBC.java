package Saiita.cn.JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class JDBC {
	public static Log logger = LogFactory.getLog(JDBC.class);
	// MySQL的数据库
	String database = "saiita.cn";
	String utf8 = "?useUnicode=true&characterEncoding=utf8";
	private String url = "jdbc:mysql://39.105.51.6:3306/" + database+utf8;
	private String Ubuntu = "jdbc:mysql://localhost:3306/" + database+utf8;
	private String username = "root";
	private String UbuntuPwd = "root";
	private String password = "************@@";
	Connection conn;

	public Connection getConnection() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			logger.info("数据库加载成功");
		} catch (Exception e) {
			logger.error("数据库加载失败" + "/n" + e);
		}
		try {
			conn = DriverManager.getConnection(url, username, password);
			logger.info("方式1：数据库加载成功");
		} catch (SQLException e) {
			try {
				logger.info("方式1：连接数据库失败，尝试连接方式2.");
				conn = DriverManager.getConnection(Ubuntu, username, UbuntuPwd);
				logger.info("方式2连接数据库成功！");
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				logger.error("方式1：连接失败" + "/n" + "方式2：连接失败");
				logger.error("请检查连接数据库账号，IP，端口是否正确！");
				logger.error(e1);
			}
		}
		return conn;
	}
}