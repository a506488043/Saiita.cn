package Saiita.cn.service.GetInfo;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.mysql.jdbc.Connection;

import Saiita.cn.JDBC.JDBC;
/*
 * ֧�����˵�����
 */
public class ToltalAlipay {
	static JDBC jdbc = new JDBC();
	public static Log logger = LogFactory.getLog(ToltalAlipay.class);

	public void ToltalAlipay() throws SQLException {
		logger.info("���ڼ���֧�������˵���������������");
		Connection getConnetcion = (Connection) jdbc.getConnection();
		String alipayTotal = "update amountTotal set totalRevenue=(select count(Amount)as totalRevenue from alipay where  BalanceOfPayments='����'),totalDisbursement=(select count(Amount)as totalDisbursement from alipay where  BalanceOfPayments='֧��'),grossIncome=(select sum(Amount)as grossIncome from alipay where  BalanceOfPayments='����'),totalExpenditure=(select sum(Amount)as totalExpenditure from alipay where  BalanceOfPayments='֧��')where projects='֧����'";
		PreparedStatement pstmt;
		int i = 0;
		// ���¼��㣺��֧����������֧����������������������
		pstmt = getConnetcion.prepareStatement(alipayTotal);
		i = pstmt.executeUpdate();
		pstmt.close();
		getConnetcion.close();
	}
}
