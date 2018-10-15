package Test;

import java.math.BigDecimal;
import java.sql.SQLException;

import Saiita.cn.service.GetInfo.getCreditCard;

public class Test {
	public static void main(String[] args) throws SQLException {
		getCreditCard get = new getCreditCard();
		//System.out.println((new BigDecimal("100.99").multiply(new BigDecimal("0.01"))).setScale(2,
		//		BigDecimal.ROUND_HALF_UP));
		get.calculate("60000");

	}
}
