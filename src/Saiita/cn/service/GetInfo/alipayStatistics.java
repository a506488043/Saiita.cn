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
 * 支付宝收入支出统计 金额 笔数
 * 
 * @author Cheng
 *
 */
public class alipayStatistics {
	static JDBC jdbc = new JDBC();
	public static Log logger = LogFactory.getLog(alipayStatistics.class);
	public static List<alipayStatisticsInfo> alipayStatisticsinfo()  {
		logger.info("支付宝账单统计");
		Connection getConnetcion = (Connection) jdbc.getConnection();
		// 更新统计支付宝账单数据
		logger.info("更新统计支付宝账单数据");
		// 更新计算：总支出笔数，总支出金额，总收入笔数，总收入金额，
		try {
			new ToltalAlipay().ToltalAlipay();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			logger.error("统计支付宝账单出错"+"\n"+e1);
		}
		List<alipayStatisticsInfo> list = new ArrayList<alipayStatisticsInfo>();
		try {
			PreparedStatement pstmt;
			// 计算统计表amountTotal
			String sql = "SELECT* from amountTotal";
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
				alipay.setId(rs.getInt("id"));
				list.add(alipay);

			}
			pstmt.close();
			getConnetcion.close();

		} catch (Exception e) {
			// TODO: handle exception
			logger.error("获取amountTotal表失败"+":"+e.getMessage());
		}

		return list;
	}
}
