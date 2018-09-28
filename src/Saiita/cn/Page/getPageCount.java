package Saiita.cn.Page;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.mysql.jdbc.Connection;

import Saiita.cn.JDBC.JDBC;
/**
 * ������ҳ��
 * @author www.saiita.cn
 *
 */
public class getPageCount {
	static JDBC jdbc = new JDBC();
	Connection getConnetcion = (Connection) jdbc.getConnection();

	public int PageCount(int pageSize) throws Exception {
		try {
			PreparedStatement pstmt;
			// ������ҳ��
			String sql = "SELECT count(*)  from alipay";
			pstmt = getConnetcion.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			rs.next();
			int rowsCount = rs.getInt(1);
			int pageCount = (int) Math.ceil(1.0 * rowsCount / pageSize);// ����ܹ���Ҫ����ҳ
			pstmt.close();
			return pageCount;
		} finally {

			getConnetcion.close();
		}
	}
}