package Saiita.cn.service.GetInfo;

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

	public static List<creditCard> getCreditCardinfo() throws SQLException {
		getConnetcion conn = new getConnetcion();
		List<creditCard> list = new ArrayList<creditCard>();
		PreparedStatement pstmt;
		// 计算统计表amountTotal
		String sql = "SELECT* from creditCard";
		pstmt = conn.Connetcion().prepareStatement(sql);
		ResultSet rs = pstmt.executeQuery();
		while (rs.next()) {
			creditCard card = new creditCard();
			card.setDaily_handling_charge(rs.getFloat("Daily_handling_charge"));
			card.setEach_of_the_principal(rs.getBigDecimal("Each_of_the_principal"));
			card.setId(rs.getString("id"));
			card.setNper(rs.getInt("nper"));
			card.setPrincipal_handling_fee(rs.getBigDecimal("Principal_handling_fee"));
			card.setRate(rs.getString("rate"));
			card.setSingle_handling_charge(rs.getBigDecimal("Single_handling_charge"));
			card.setTotal_fee(rs.getFloat("total_fee"));
			list.add(card);
		}
		;
		return list;
	}
	
	public static List<creditCard> calculate() throws SQLException {
		getConnetcion conn = new getConnetcion();
		List<creditCard> list = new ArrayList<creditCard>();
		PreparedStatement pstmt;
		// 计算统计表amountTotal
		String sql = "SELECT* from creditCard";
		pstmt = conn.Connetcion().prepareStatement(sql);
		ResultSet rs = pstmt.executeQuery();
		while (rs.next()) {
			creditCard card = new creditCard();
			card.setDaily_handling_charge(rs.getInt("Daily_handling_charge"));
			card.setEach_of_the_principal(rs.getBigDecimal("Each_of_the_principal"));
			card.setId(rs.getString("id"));
			card.setNper(rs.getInt("nper"));
			card.setPrincipal_handling_fee(rs.getBigDecimal("Principal_handling_fee"));
			card.setRate(rs.getString("rate"));
			card.setSingle_handling_charge(rs.getBigDecimal("Single_handling_charge"));
			card.setTotal_fee(rs.getInt("total_fee"));
			list.add(card);
		}
		;
		return list;
	}

}
