package Saiita.cn.service.GetInfo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.mysql.jdbc.Connection;

import Saiita.cn.JDBC.JDBC;
import Saiita.cn.entity.alipayStatisticsInfo;

public class Total {
	static JDBC jdbc = new JDBC();
	public static Log logger = LogFactory.getLog(Total.class);

	public static List<alipayStatisticsInfo> Total() throws SQLException {
		logger.info("֧�����˵�ͳ��(�˵���ͳ��)Total");
		Connection getConnetcion = (Connection) jdbc.getConnection();
		// ����ͳ��֧�����˵�����
		logger.info("ʵʱ����ͳ������");
		new ToltalOne().ToltalOne();
		List<alipayStatisticsInfo> list = new ArrayList<alipayStatisticsInfo>();
		try {
			PreparedStatement pstmt;
			// ����ͳ�Ʊ�amountTotal
			String sql = "SELECT* from Total where projects='ͳ��'";
			pstmt = getConnetcion.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				alipayStatisticsInfo alipay = new alipayStatisticsInfo();
				// ��֧�����
				alipay.setTotalExpenditure(rs.getFloat("totalExpenditure"));
				// ��������
				alipay.setGrossIncome(rs.getFloat("grossIncome"));
				// ���ÿ�͸֧
				alipay.setCreditCardOverdraft(rs.getFloat("creditCardOverdraft"));
				// ���
				alipay.setDeficit(rs.getFloat("deficit"));
				// ��Ŀ
				alipay.setProjects(rs.getString("projects"));
				// ��֧������
				alipay.setTotalDisbursement(rs.getInt("totalDisbursement"));
				// ���������
				alipay.setTotalRevenue(rs.getInt("totalRevenue"));
				// id
				list.add(alipay);
			}
			pstmt.close();
			getConnetcion.close();

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			logger.error("��ȡTotal��ʧ��");
		}
		return list;
	}

}
