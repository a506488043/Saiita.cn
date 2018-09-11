package Saiita.cn.service.Login;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import com.mysql.jdbc.Connection;
import Saiita.cn.JDBC.JDBC;
import Saiita.cn.service.GetInfo.getAllUserInfo;
import Saiita.cn.service.GetInfo.Log.LogRecord;
import Saiita.cn.service.GetSystemInformation.Browser;
import Saiita.cn.service.GetSystemInformation.GetSystemTime;

public class CheckLoginInfo {
	static JDBC jdbc = new JDBC();
	public static Log logger = LogFactory.getLog(getAllUserInfo.class);
	static Browser getBrowser = new Browser();
	static LogRecord log = new LogRecord();

	@SuppressWarnings("resource")
	public static String checkLogin(String username, String password, String ip, String Agent) throws SQLException {
		logger.info("用户登陆验证!");
		String browser = getBrowser.getBrowserName(Agent);
		// 用户输入账号参数安全校验
		String[] value = { username, password };
		// 连接数据库
		Connection getConnetcion = (Connection) jdbc.getConnection();
		// 输入用户名查询密码等信息
		String sql = "SELECT * from user where username=?";
		PreparedStatement pstmt = null;
		// 获取系统时间，设置日期格式
		GetSystemTime systemtime = new GetSystemTime();
		long l = systemtime.GetSyetemTimes();
		try {
			// 执行
			pstmt = getConnetcion.prepareStatement(sql);
			//
			pstmt.setString(1, username);
			// 返回结果集
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				// 获得密码
				String checkPasswd = rs.getString("password");
				// 查询的密码和输入的密码对比，正确的进入
				if (checkPasswd.equals(password) || password.equals(checkPasswd)) {
					// 记录登陆信息
					log.logrecorc(username, l, "用户登陆", "登陆成功", "1", ip, browser, Agent);
					// 获得登陆成功次数
					int Loginsuccess = rs.getInt("LoginSuccess");
					// 成功一次，LoginSuccess次数增加一次
					int count = ++Loginsuccess;
					logger.info("登陆成功次数:" + Loginsuccess);
					String lastLoginTime = "update user set LoginSuccess =? ,Lastlogintime =? , LoginSuccessDate=? where User =?";
					pstmt = getConnetcion.prepareStatement(lastLoginTime);
					pstmt.setInt(1, count);
					pstmt.setLong(2, l);
					pstmt.setLong(3, l);
					pstmt.setString(4, username);
					pstmt.executeUpdate();
					// 关闭数据库操作
					logger.info("关闭数据库操作");
					pstmt.close();
					getConnetcion.close();
					return "Success";
				} else {
					// 记录登陆失败
					log.logrecorc(username, l, "用户登陆", "用户名或密码错误", "1", ip, browser, Agent);
					// 获得登陆失败次数
					int Loginfailed = rs.getInt("Loginfailure");
					// 失败一次，Loginfailure次数增加一次
					int count = ++Loginfailed;
					// 获取登陆失败时的系统时间。
					logger.info("登陆失败次数:" + Loginfailed + "," + "用户名或密码错误");
					String LoginCountSql = "update user set  Loginfailure=? , LoginfailureDate=? where User =?";
					pstmt = getConnetcion.prepareStatement(LoginCountSql);
					pstmt.setInt(1, count);
					pstmt.setLong(2, l);
					pstmt.setString(3, username);
					pstmt.executeUpdate();
					// 关闭数据库操作
					logger.info("关闭数据库操作");
					pstmt.close();
					getConnetcion.close();
					return "failed";
				}
			} else {
				log.logrecorc(username, l, "用户登陆", "用户名或密码错误", "1", ip, browser, Agent);
				return "No data";
			}
		} catch (Exception e) {
			// TODO: handle exception
			logger.error("获取Usre表失败" + ":" + e.getMessage());
			if (ip.length() >= 31) {
				log.logrecorc(username, l, "用户登陆", e.getMessage(), "1", "超出IP长度", browser, Agent);
			} else if (username.length() >= 17) {
				log.logrecorc("输入长度超过用户名长度", l, "用户登陆", e.getMessage(), "1", ip, browser, Agent);
			}
			return "failed";
		}
	}
}
