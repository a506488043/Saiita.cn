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
		logger.info("获取系统日志");
		Connection getConnetcion = (Connection) jdbc.getConnection();
		List<SafeLog> list = new ArrayList<SafeLog>();
		PreparedStatement pstmt = null;
		// 计算统计表amountTotal
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
		// 日志记录
		LogRecord log = new LogRecord();
		// 判断浏览器类型
		Browser browser = new Browser();
		Connection getConnetcion = (Connection) jdbc.getConnection();
		PreparedStatement pstmt;
		// 计算统计表amountTotal
		String sql = "SELECT COUNT(ip) as size from safetyLog";
		pstmt = getConnetcion.prepareStatement(sql);
		ResultSet rs = pstmt.executeQuery();
		rs.next();
		int size = rs.getInt("size");
		pstmt.close();
		getConnetcion.close();
		log.logrecorc(username, GetSystemTime.GetSyetemTimes(), "系统日志总条数：" + size + "条", "查询系统日志", "2", ip,
				browser.getBrowserName(bowserType), bowserType);
		return size;
	}
}
