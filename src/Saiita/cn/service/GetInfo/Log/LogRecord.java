package Saiita.cn.service.GetInfo.Log;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.mysql.jdbc.Connection;

import Saiita.cn.JDBC.JDBC;

/**
 * �û���½��¼��־
 * 
 * @author Cheng
 *
 */
public class LogRecord {
	static JDBC jdbc = new JDBC();
	public static Log logger = LogFactory.getLog(LogRecord.class);
	PreparedStatement pstmt = null;
	String sql = "INSERT INTO safetyLog (username,datetime,operation,result,safetylog,ip,browser,BrowserType) VALUES(?,?,?,?,?,?,?,?);";

	public void logrecorc(String username, long datetime, String result, String operation, String safelog, String ip,
			String browser, String browserType) throws SQLException {
		logger.info("��½��־��¼");
		// �������ݿ�
		Connection getConnetcion = (Connection) jdbc.getConnection();
		pstmt = getConnetcion.prepareStatement(sql);
		pstmt.setString(1, username);
		pstmt.setLong(2, datetime);
		pstmt.setString(3, result);
		pstmt.setString(4, operation);
		pstmt.setString(5, safelog);
		pstmt.setString(6, ip);
		pstmt.setString(7, browser);
		pstmt.setString(8, browserType);
		pstmt.executeUpdate();
		// �ر����ݿ����
		logger.info("�ر����ݿ����");
		pstmt.close();
		getConnetcion.close();
	}
}
