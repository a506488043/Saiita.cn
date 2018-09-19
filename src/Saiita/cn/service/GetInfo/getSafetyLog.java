package Saiita.cn.service.GetInfo;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.mysql.jdbc.Connection;

import Saiita.cn.JDBC.JDBC;
import Saiita.cn.service.GetSystemInformation.GetSystemTime;
import Saiita.cn.entity.SafeLog;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
/**
  * 获取系统日志
 */
public class getSafetyLog {
	static JDBC jdbc = new JDBC();
	public static Log logger = LogFactory.getLog(alipayStatistics.class);
	GetSystemTime getSysTime = new GetSystemTime();
	PreparedStatement pstmt = null;

	public static List<SafeLog> getLogInfo() throws SQLException {
		logger.info("获取系统日志");
		Connection getConnetcion = (Connection) jdbc.getConnection();
		List<SafeLog> list = new ArrayList<SafeLog>();
		PreparedStatement pstmt = null;
		String sql = "SELECT*FROM safetyLog where safetylog = '1' order by id desc";
		pstmt = getConnetcion.prepareStatement(sql);
		ResultSet rs = pstmt.executeQuery();
		while (rs.next()) {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			SafeLog safelist = new SafeLog();
			safelist.setId(rs.getString("id"));
			safelist.setUsername(rs.getString("username"));
			safelist.setDatetime(sdf.format(rs.getLong("datetime")));
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
}
