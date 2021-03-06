package Saiita.cn.service.GetInfo;

import java.math.BigDecimal;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import Saiita.cn.JDBC.getConnetcion;
import Saiita.cn.entity.creditCard;

public class getCreditCard {
	public static Log logger = LogFactory.getLog(getCreditCard.class);
	static getConnetcion conn = new getConnetcion();
	static PreparedStatement pstmt;
	static String multiple = "100";
	static String days = "100";

	public static List<creditCard> getCreditCardinfo() throws SQLException {
		List<creditCard> list = new ArrayList<creditCard>();

		// 计算统计表amountTotal
		String sql = "SELECT* from creditCard";
		pstmt = conn.Connetcion().prepareStatement(sql);
		ResultSet rs = pstmt.executeQuery();
		while (rs.next()) {
			creditCard card = new creditCard();
			card.setDaily_handling_charge(rs.getBigDecimal("Daily_handling_charge"));
			card.setEach_of_the_principal(rs.getBigDecimal("Each_of_the_principal"));
			card.setId(rs.getInt("id"));

			String result1 = String.valueOf(rs.getInt("nper"));
			card.setNper(result1 + "期");
			card.setPrincipal_handling_fee(rs.getBigDecimal("Principal_handling_fee"));

			BigDecimal nper = new BigDecimal(Double.toString(100.00));
			BigDecimal rate = rs.getBigDecimal("rate");
			String result = String.valueOf(rate.multiply(nper).doubleValue());
			card.setRate(result + "%");

			card.setSingle_handling_charge(rs.getBigDecimal("Single_handling_charge"));
			card.setTotal_fee(rs.getBigDecimal("total_fee"));
			list.add(card);
		}
		;
		return list;
	}

	public static void calculate(String amount) {
		try {
			List<creditCard> list = getCreditCardinfo();
			for (int i = 0; i < list.size(); i++) {
				creditCard cred = list.get(i);

				String sql = "UPDATE creditCard SET "
						// 每期本金
						+ "Each_of_the_principal= ?,"
						// 单期手续费
						+ "Single_handling_charge= ?,"
						// 本金+手续费
						+ "Principal_handling_fee= ?,"
						// 每日手续费
						+ "Daily_handling_charge= ?,"
						// 总手续费
						+ "total_fee= ? " + "where id='" + cred.getId() + "'";

				pstmt = conn.Connetcion().prepareStatement(sql);

				// 期数
				String nper = cred.getNper();
				String result = nper.replaceAll("期", "");
				// 费率
				String rate = cred.getRate();
				String resultrate = rate.replace("%", "");
				// 每期本金
				pstmt.setBigDecimal(1,
						(new BigDecimal(amount)).divide(new BigDecimal(result), 2, BigDecimal.ROUND_HALF_UP));
				// 单期手续费
				pstmt.setBigDecimal(2,
						(new BigDecimal(amount).multiply(new BigDecimal(resultrate).divide(new BigDecimal(multiple))))
								.setScale(2, BigDecimal.ROUND_HALF_UP));
				// 本金+手续费
				pstmt.setBigDecimal(3,
						(new BigDecimal(amount)).divide(new BigDecimal(result), 2, BigDecimal.ROUND_HALF_UP)
								.add((new BigDecimal(amount)
										.multiply(new BigDecimal(resultrate).divide(new BigDecimal(multiple))))
												.setScale(2, BigDecimal.ROUND_HALF_UP)));
				// 每日手续费
				BigDecimal Daily_handling_charge = new BigDecimal(amount)
						.multiply((new BigDecimal(resultrate).divide(new BigDecimal(multiple))));

				pstmt.setBigDecimal(4, Daily_handling_charge.divide(new BigDecimal(days), 2, BigDecimal.ROUND_HALF_UP));
				// 总手续费
				pstmt.setBigDecimal(5,
						(new BigDecimal(amount).multiply(new BigDecimal(resultrate).divide(new BigDecimal(multiple))))
								.setScale(2, BigDecimal.ROUND_HALF_UP).multiply(new BigDecimal(result)));

				pstmt.executeUpdate();
				pstmt.close();
				conn.Connetcion().close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
