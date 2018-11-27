package Saiita.cn.service.RSA;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.mysql.jdbc.Connection;

import RSA.RSAUtil;
import Saiita.cn.JDBC.JDBC;

/**
 * 获取modulus和encryptionExponent
 * 
 * @author Cheng
 *
 */
public class RSADecryption {
	RSAUtil rsa = new RSAUtil();
	static JDBC jdbc = new JDBC();
	public static Log logger = LogFactory.getLog(RSADecryption.class);
	RSADecryption key = new RSADecryption();
	//公共密钥存入数据库，1001
	public void getModulusandEncryptionExponent() throws SQLException {
		PreparedStatement pstmt = null;
		logger.info("RSA");
		// 连接数据库
		Connection getConnetcion = (Connection) jdbc.getConnection();
		// 输入用户名查询密码等信息
		String publickey = "UPDATE RSA set publickey=?,Modulus=?,datatime=?";
		pstmt = getConnetcion.prepareStatement(publickey);
		try {
			// 获取公密钥,用于密码加密
			String PublicKey = RSAUtil.generateKeyPair().getPublic().toString();
			// 后去私密钥,用于密码加密解密
			String PrivateKey = RSAUtil.generateKeyPair().getPrivate().toString();
			// 公共密钥
			pstmt.setString(1, PublicKey.substring(316, 321));
			// Modulus
			pstmt.setString(1, PublicKey.substring(37, 293));
			// 获取系统时间，设置日期格式
			pstmt.setLong(3,System.currentTimeMillis());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			logger.error("获取Modulus失败" + ":" + e.getMessage());
		}
	}
	
}
