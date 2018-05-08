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
		logger.info("支付宝账单统计(账单总统计)Total");
		Connection getConnetcion = (Connection) jdbc.getConnection();
		// 更新统计支付宝账单数据
		logger.info("实时更新统计数据");
		new ToltalOne().ToltalOne();
		List<alipayStatisticsInfo> list = new ArrayList<alipayStatisticsInfo>();
		try {
			PreparedStatement pstmt;
			// 计算统计表amountTotal
			String sql = "SELECT* from Total where projects='统计'";
			pstmt = getConnetcion.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				alipayStatisticsInfo alipay = new alipayStatisticsInfo();
				// 总支出金额
				alipay.setTotalExpenditure(rs.getFloat("totalExpenditure"));
				// 总收入金额
				alipay.setGrossIncome(rs.getFloat("grossIncome"));
				// 信用卡透支
				alipay.setCreditCardOverdraft(rs.getFloat("creditCardOverdraft"));
				// 逆差
				alipay.setDeficit(rs.getFloat("deficit"));
				// 项目
				alipay.setProjects(rs.getString("projects"));
				// 总支出笔数
				alipay.setTotalDisbursement(rs.getInt("totalDisbursement"));
				// 总收入笔数
				alipay.setTotalRevenue(rs.getInt("totalRevenue"));
				// id
				list.add(alipay);
			}
			pstmt.close();
			getConnetcion.close();

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			logger.error("获取Total表失败");
		}
		return list;
	}

}
