package Saiita.cn.service.RSA;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.mysql.jdbc.Connection;

import RSA.RSAUtil;
import Saiita.cn.JDBC.JDBC;

/**
 * ��ȡmodulus��encryptionExponent
 * 
 * @author Cheng
 *
 */
public class RSADecryption {
	RSAUtil rsa = new RSAUtil();
	static JDBC jdbc = new JDBC();
	public static Log logger = LogFactory.getLog(RSADecryption.class);
	RSADecryption key = new RSADecryption();
	//������Կ�������ݿ⣬1001
	public void getModulusandEncryptionExponent() throws SQLException {
		PreparedStatement pstmt = null;
		logger.info("RSA");
		// �������ݿ�
		Connection getConnetcion = (Connection) jdbc.getConnection();
		// �����û�����ѯ�������Ϣ
		String publickey = "UPDATE RSA set publickey=?,Modulus=?,datatime=?";
		pstmt = getConnetcion.prepareStatement(publickey);
		try {
			// ��ȡ����Կ,�����������
			String PublicKey = RSAUtil.generateKeyPair().getPublic().toString();
			// ��ȥ˽��Կ,����������ܽ���
			String PrivateKey = RSAUtil.generateKeyPair().getPrivate().toString();
			// ������Կ
			pstmt.setString(1, PublicKey.substring(316, 321));
			// Modulus
			pstmt.setString(1, PublicKey.substring(37, 293));
			// ��ȡϵͳʱ�䣬�������ڸ�ʽ
			pstmt.setLong(3,System.currentTimeMillis());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			logger.error("��ȡModulusʧ��" + ":" + e.getMessage());
		}
	}
	
}
