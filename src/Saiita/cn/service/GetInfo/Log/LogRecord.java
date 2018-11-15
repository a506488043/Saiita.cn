package Saiita.cn.service.GetInfo.Log;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.mysql.jdbc.Connection;

import Saiita.cn.JDBC.JDBC;
import Saiita.cn.service.GetSystemInformation.Browser;
import Saiita.cn.service.GetSystemInformation.GetSystemTime;

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
	// ��ȡ���������
	static Browser getBrowser = new Browser();
	// ��ȡϵͳʱ��
	GetSystemTime getSystemTime = new GetSystemTime();

	public void log(String name, String browserType, String ip, String result, String operation, String safelog)
			throws SQLException {
		logrecorc(name, GetSystemTime.GetSyetemTimes(), result, operation, safelog, ip,
				getBrowser.getBrowserName(browserType), browserType);
	}

	public void logrecorc(String username, long datetime, String result, String operation, String safelog, String ip,
			String browser, String browserType) throws SQLException {
		logger.info("��½��־��¼");
		// �������ݿ�
		String sql = "INSERT INTO safetyLog (username,datetime,operation,result,safetylog,ip,browser,BrowserType) VALUES(?,?,?,?,?,?,?,?);";
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
