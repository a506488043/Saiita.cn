package Saiita.cn.service.GetInfo;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.mysql.jdbc.Connection;

import Saiita.cn.JDBC.JDBC;
/**
 * ���˵�����
 * @author Cheng
 *
 */
public class ToltalOne {
	static JDBC jdbc = new JDBC();
	public static Log logger = LogFactory.getLog(ToltalOne.class);

	public void ToltalOne() throws SQLException {
		logger.info("���ڼ������˵�������������������");
		Connection getConnetcion = (Connection) jdbc.getConnection();
		String Total = "update Total set totalRevenue=(select sum(totalRevenue) from amountTotal),totalDisbursement=(select sum(totalDisbursement) from amountTotal),grossIncome=(select sum(grossIncome) from amountTotal),totalExpenditure=(select sum(totalExpenditure) from amountTotal),deficit=(select sum(deficit) from amountTotal),creditCardOverdraft=(select sum(creditCardOverdraft) from amountTotal)where projects='ͳ��'";
		PreparedStatement pstmt;
		int i = 0;
		// ���¼��㣺��֧����������֧����������������������
		pstmt = getConnetcion.prepareStatement(Total);
		i = pstmt.executeUpdate();
		pstmt.close();
		getConnetcion.close();
	}
}
