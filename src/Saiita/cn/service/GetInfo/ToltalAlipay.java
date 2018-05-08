package Saiita.cn.service.GetInfo;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.mysql.jdbc.Connection;

import Saiita.cn.JDBC.JDBC;
/*
 * 支付宝账单计算
 */
public class ToltalAlipay {
	static JDBC jdbc = new JDBC();
	public static Log logger = LogFactory.getLog(ToltalAlipay.class);

	public void ToltalAlipay() throws SQLException {
		logger.info("正在计算支付宝总账单。。。。。。。");
		Connection getConnetcion = (Connection) jdbc.getConnection();
		String alipayTotal = "update amountTotal set totalRevenue=(select count(Amount)as totalRevenue from alipay where  BalanceOfPayments='收入'),totalDisbursement=(select count(Amount)as totalDisbursement from alipay where  BalanceOfPayments='支出'),grossIncome=(select sum(Amount)as grossIncome from alipay where  BalanceOfPayments='收入'),totalExpenditure=(select sum(Amount)as totalExpenditure from alipay where  BalanceOfPayments='支出')where projects='支付宝'";
		PreparedStatement pstmt;
		int i = 0;
		// 更新计算：总支出笔数，总支出金额，总收入笔数，总收入金额，
		pstmt = getConnetcion.prepareStatement(alipayTotal);
		i = pstmt.executeUpdate();
		pstmt.close();
		getConnetcion.close();
	}
}
