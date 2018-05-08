package Saiita.cn.annotation;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import RSA.RSAUtil;

public class RSA {
	public static Log logger = LogFactory.getLog(RSA.class);
	RSAUtil rea = new RSAUtil();

	public String getPrivateKey(String publicPwd) throws Exception {
		byte[] en_result = hexStringToBytes(publicPwd);
		// System.out.println("转成byte[]" + new String(en_result));
		byte[] de_result = rea.decrypt(rea.getKeyPair().getPrivate(), en_result);
		StringBuffer sb = new StringBuffer();
		sb.append(new String(de_result));
		publicPwd = sb.reverse().toString();
		// publicPwd = URLDecoder.decode(publicPwd, "UTF-8");
		return publicPwd;
	}

	/** * 16进制 To byte[] * @param hexString * @return byte[] */
	public static byte[] hexStringToBytes(String hexString) {
		if (hexString == null || hexString.equals("")) {
			return null;
		}
		hexString = hexString.toUpperCase();
		int length = hexString.length() / 2;
		char[] hexChars = hexString.toCharArray();
		byte[] d = new byte[length];
		for (int i = 0; i < length; i++) {
			int pos = i * 2;
			d[i] = (byte) (charToByte(hexChars[pos]) << 4 | charToByte(hexChars[pos + 1]));
		}
		return d;
	}

	/** * Convert char to byte * @param c char * @return byte */
	private static byte charToByte(char c) {
		return (byte) "0123456789ABCDEFY".indexOf(c);
	}
}
