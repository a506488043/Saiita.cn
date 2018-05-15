package Saiita.cn.service.GetInfo;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.mysql.jdbc.Connection;

import Saiita.cn.JDBC.JDBC;
import Saiita.cn.service.GetInfo.Log.LogRecord;
import Saiita.cn.service.GetSystemInformation.Browser;
import Saiita.cn.service.GetSystemInformation.GetSystemTime;
import Saiita.cn.entity.SafeLog;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class getSafetyLog {
	static JDBC jdbc = new JDBC();
	public static Log logger = LogFactory.getLog(alipayStatistics.class);
	GetSystemTime getSysTime = new GetSystemTime();
	PreparedStatement pstmt = null;

	public static List<SafeLog> getLogInfo(int i) throws SQLException {
		logger.info("��ȡϵͳ��־");
		Connection getConnetcion = (Connection) jdbc.getConnection();
		List<SafeLog> list = new ArrayList<SafeLog>();
		PreparedStatement pstmt = null;
		// ����ͳ�Ʊ�amountTotal
		String sql = "SELECT*FROM safetyLog LIMIT ?,?";
		pstmt = getConnetcion.prepareStatement(sql);
		
		pstmt.setInt(1, i*10);
		pstmt.setInt(2, i+10);
		
		ResultSet rs = pstmt.executeQuery();
		while (rs.next()) {
			SafeLog safelist = new SafeLog();
			safelist.setUsername(rs.getString("username"));
			safelist.setDatetime(rs.getString("datetime"));
			safelist.setOperation(rs.getString("operation"));
			safelist.setResult(rs.getString("result"));
			safelist.setIp(rs.getString("ip"));
			safelist.setBrowser(rs.getString("browser"));
			list.add(safelist);
		}
		pstmt.close();
		getConnetcion.close();
		return list;
	}

	public int records(String username, String ip, String bowserType) throws SQLException {
		// ��־��¼
		LogRecord log = new LogRecord();
		// �ж����������
		Browser browser = new Browser();
		Connection getConnetcion = (Connection) jdbc.getConnection();
		PreparedStatement pstmt;
		// ����ͳ�Ʊ�amountTotal
		String sql = "SELECT COUNT(ip) as size from safetyLog";
		pstmt = getConnetcion.prepareStatement(sql);
		ResultSet rs = pstmt.executeQuery();
		rs.next();
		int size = rs.getInt("size");
		pstmt.close();
		getConnetcion.close();
		log.logrecorc(username, GetSystemTime.GetSyetemTimes(), "ϵͳ��־��������" + size + "��", "��ѯϵͳ��־", "2", ip,
				browser.getBrowserName(bowserType), bowserType);
		return size;
	}
}
