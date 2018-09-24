package Saiita.cn.service.GetInfo;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.mysql.jdbc.Connection;

import Saiita.cn.entity.alipayStatisticsInfo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Saiita.cn.JDBC.JDBC;

/**
 * ֧��������֧��ͳ�� ��� ����
 * 
 * @author Cheng
 *
 */
public class alipayStatistics {
	static JDBC jdbc = new JDBC();
	public static Log logger = LogFactory.getLog(alipayStatistics.class);
	public static List<alipayStatisticsInfo> alipayStatisticsinfo()  {
		logger.info("֧�����˵�ͳ��");
		Connection getConnetcion = (Connection) jdbc.getConnection();
		// ����ͳ��֧�����˵�����
		logger.info("����ͳ��֧�����˵�����");
		// ���¼��㣺��֧����������֧����������������������
		try {
			new ToltalAlipay().ToltalAlipay();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			logger.error("ͳ��֧�����˵�����"+"\n"+e1);
		}
		List<alipayStatisticsInfo> list = new ArrayList<alipayStatisticsInfo>();
		try {
			PreparedStatement pstmt;
			// ����ͳ�Ʊ�amountTotal
			String sql = "SELECT* from amountTotal";
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
				alipay.setId(rs.getInt("id"));
				list.add(alipay);

			}
			pstmt.close();
			getConnetcion.close();

		} catch (Exception e) {
			// TODO: handle exception
			logger.error("��ȡamountTotal��ʧ��"+":"+e.getMessage());
		}

		return list;
	}
}
