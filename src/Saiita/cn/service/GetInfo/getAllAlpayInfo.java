package Saiita.cn.service.GetInfo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.mysql.jdbc.Connection;

import Saiita.cn.JDBC.JDBC;
import Saiita.cn.entity.alipayInfo;

public class getAllAlpayInfo {
	/**
	 * 获取支付宝账单信息
	 */
	static JDBC jdbc = new JDBC();
	public static Log logger = LogFactory.getLog(getAllUserInfo.class);

	public static List<alipayInfo> getAllAlpayInfo() {
		logger.info("获取Alipay表数据");
		Connection getConnetcion = (Connection) jdbc.getConnection();
		String sql = "SELECT* from alipay ";
		PreparedStatement pstmt;
		List<alipayInfo> getAlipayInfoList = new ArrayList<alipayInfo>();
		try {
			pstmt = getConnetcion.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				alipayInfo alipay = new alipayInfo();
				alipay.setId(rs.getInt("Id"));
				alipay.setAmount(rs.getFloat("Amount"));
				alipay.setBalanceOfPayments(rs.getString("BalanceOfPayments"));
				alipay.setCommodityName(rs.getString("CommodityName"));
				alipay.setMerchantOrderNumber(rs.getString("MerchantOrderNumber"));
				alipay.setPaymentTime(rs.getString("PaymentTime"));
				alipay.setRecentModificationTime(rs.getString("RecentModificationTime"));
				alipay.setRemark(rs.getString("Remark"));
				alipay.setSourceTransation(rs.getString("SourceTransation"));
				alipay.setStateFunding(rs.getString("StateFunding"));
				alipay.setSuccessfulRefund(rs.getString("SuccessfulRefund"));
				alipay.setTheDealingParty(rs.getString("TheDealingParty"));
				alipay.setTheServiceFee(rs.getString("TheServiceFee"));
				alipay.setTradeNumber(rs.getString("TradeNumber"));
				alipay.setTransactionCreationTime(rs.getString("TransactionCreationTime"));
				alipay.setTransationStatus(rs.getString("TransationStatus"));
				alipay.setType(rs.getString("Type"));
				getAlipayInfoList.add(alipay);
			}
			pstmt.close();
			getConnetcion.close();
		} catch (Exception e) {
			// TODO: handle exception
			logger.error("获取Alipay表失败"+":"+e.getMessage());
		}
		return getAlipayInfoList;
	}
}
