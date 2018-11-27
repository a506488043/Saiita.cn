package Test;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.codec.binary.Base64;

import RSA.RSAUtil;
import Saiita.cn.entity.RsaKey;

public class Test {
	public static void main(String[] args) throws SQLException {
		RSAUtil rsa =new RSAUtil();
		RsaKey key = new RsaKey();
		List<RsaKey> list = new ArrayList<RsaKey>();
		try {
			key.setPublicKey(rsa.getKeyPair().getPublic().toString());
			list.add(key);
			System.out.println(rsa.getKeyPair().getPublic().toString().substring(37,293));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
