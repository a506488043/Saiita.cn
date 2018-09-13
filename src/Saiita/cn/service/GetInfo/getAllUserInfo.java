package Saiita.cn.service.GetInfo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.mysql.jdbc.Connection;

import Saiita.cn.JDBC.JDBC;
import Saiita.cn.entity.*;

public class getAllUserInfo {
	/**
	 * 获取用户全部信息
	 */
	static JDBC jdbc = new JDBC();
	public static Log logger = LogFactory.getLog(getAllUserInfo.class);

	public static List<UserInfo> getAllUserInfo() {
		logger.info("获取User表所有用户数据");
		Connection getConnetcion = (Connection) jdbc.getConnection();
		String sql = "SELECT* from user ";
		PreparedStatement pstmt;
		List<UserInfo> getUserInfoList = new ArrayList<UserInfo>();
		try {
			pstmt = getConnetcion.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				UserInfo User = new UserInfo();
				User.setId(rs.getInt("id"));
				User.setRole(rs.getInt("role"));
				User.setUsername(rs.getString("username"));
				User.setPassword(rs.getString("password"));
				User.setLoginfailure(rs.getInt("Loginfailure"));
				User.setLoginSuccess(rs.getInt("LoginSuccess"));
				User.setCreatime(sdf.format(rs.getLong("creatime")));
				User.setLastLoginTime(sdf.format(rs.getLong("lastLoginTime")));
				User.setLoginfailureDate(sdf.format(rs.getLong("LoginfailureDate")));
				getUserInfoList.add(User);
			}
			pstmt.close();
			getConnetcion.close();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			logger.error("获取Usre表失败"+":"+e.getMessage());
		}
		return getUserInfoList;
	}

}
