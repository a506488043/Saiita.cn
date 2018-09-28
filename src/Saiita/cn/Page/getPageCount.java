package Saiita.cn.Page;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.mysql.jdbc.Connection;

import Saiita.cn.JDBC.JDBC;
/**
 * 计算总页数
 * @author www.saiita.cn
 *
 */
public class getPageCount {
	static JDBC jdbc = new JDBC();
	Connection getConnetcion = (Connection) jdbc.getConnection();

	public int PageCount(int pageSize) throws Exception {
		try {
			PreparedStatement pstmt;
			// 计算总页数
			String sql = "SELECT count(*)  from alipay";
			pstmt = getConnetcion.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			rs.next();
			int rowsCount = rs.getInt(1);
			int pageCount = (int) Math.ceil(1.0 * rowsCount / pageSize);// 算出总共需要多少页
			pstmt.close();
			return pageCount;
		} finally {

			getConnetcion.close();
		}
	}
}