package Saiita.cn.JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class JDBC {
	public static Log logger = LogFactory.getLog(JDBC.class);
	// MySQL�����ݿ�
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
			logger.info("���ݿ���سɹ�");
		} catch (Exception e) {
			logger.error("���ݿ����ʧ��" + "/n" + e);
		}
		try {
			conn = DriverManager.getConnection(url, username, password);
			logger.info("��ʽ1�����ݿ���سɹ�");
		} catch (SQLException e) {
			try {
				logger.info("��ʽ1���������ݿ�ʧ�ܣ��������ӷ�ʽ2.");
				conn = DriverManager.getConnection(Ubuntu, username, UbuntuPwd);
				logger.info("��ʽ2�������ݿ�ɹ���");
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				logger.error("��ʽ1������ʧ��" + "/n" + "��ʽ2������ʧ��");
				logger.error("�����������ݿ��˺ţ�IP���˿��Ƿ���ȷ��");
				logger.error(e1);
			}
		}
		return conn;
	}
}