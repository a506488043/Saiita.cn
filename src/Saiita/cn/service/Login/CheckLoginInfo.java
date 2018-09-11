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
		logger.info("�û���½��֤!");
		String browser = getBrowser.getBrowserName(Agent);
		// �û������˺Ų�����ȫУ��
		String[] value = { username, password };
		// �������ݿ�
		Connection getConnetcion = (Connection) jdbc.getConnection();
		// �����û�����ѯ�������Ϣ
		String sql = "SELECT * from user where username=?";
		PreparedStatement pstmt = null;
		// ��ȡϵͳʱ�䣬�������ڸ�ʽ
		GetSystemTime systemtime = new GetSystemTime();
		long l = systemtime.GetSyetemTimes();
		try {
			// ִ��
			pstmt = getConnetcion.prepareStatement(sql);
			//
			pstmt.setString(1, username);
			// ���ؽ����
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				// �������
				String checkPasswd = rs.getString("password");
				// ��ѯ����������������Աȣ���ȷ�Ľ���
				if (checkPasswd.equals(password) || password.equals(checkPasswd)) {
					// ��¼��½��Ϣ
					log.logrecorc(username, l, "�û���½", "��½�ɹ�", "1", ip, browser, Agent);
					// ��õ�½�ɹ�����
					int Loginsuccess = rs.getInt("LoginSuccess");
					// �ɹ�һ�Σ�LoginSuccess��������һ��
					int count = ++Loginsuccess;
					logger.info("��½�ɹ�����:" + Loginsuccess);
					String lastLoginTime = "update user set LoginSuccess =? ,Lastlogintime =? , LoginSuccessDate=? where User =?";
					pstmt = getConnetcion.prepareStatement(lastLoginTime);
					pstmt.setInt(1, count);
					pstmt.setLong(2, l);
					pstmt.setLong(3, l);
					pstmt.setString(4, username);
					pstmt.executeUpdate();
					// �ر����ݿ����
					logger.info("�ر����ݿ����");
					pstmt.close();
					getConnetcion.close();
					return "Success";
				} else {
					// ��¼��½ʧ��
					log.logrecorc(username, l, "�û���½", "�û������������", "1", ip, browser, Agent);
					// ��õ�½ʧ�ܴ���
					int Loginfailed = rs.getInt("Loginfailure");
					// ʧ��һ�Σ�Loginfailure��������һ��
					int count = ++Loginfailed;
					// ��ȡ��½ʧ��ʱ��ϵͳʱ�䡣
					logger.info("��½ʧ�ܴ���:" + Loginfailed + "," + "�û������������");
					String LoginCountSql = "update user set  Loginfailure=? , LoginfailureDate=? where User =?";
					pstmt = getConnetcion.prepareStatement(LoginCountSql);
					pstmt.setInt(1, count);
					pstmt.setLong(2, l);
					pstmt.setString(3, username);
					pstmt.executeUpdate();
					// �ر����ݿ����
					logger.info("�ر����ݿ����");
					pstmt.close();
					getConnetcion.close();
					return "failed";
				}
			} else {
				log.logrecorc(username, l, "�û���½", "�û������������", "1", ip, browser, Agent);
				return "No data";
			}
		} catch (Exception e) {
			// TODO: handle exception
			logger.error("��ȡUsre��ʧ��" + ":" + e.getMessage());
			if (ip.length() >= 31) {
				log.logrecorc(username, l, "�û���½", e.getMessage(), "1", "����IP����", browser, Agent);
			} else if (username.length() >= 17) {
				log.logrecorc("���볤�ȳ����û�������", l, "�û���½", e.getMessage(), "1", ip, browser, Agent);
			}
			return "failed";
		}
	}
}
