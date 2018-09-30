package Saiita.cn.JDBC;

import com.mysql.jdbc.Connection;

public class getConnetcion {
	static JDBC jdbc = new JDBC();

	public Connection Connetcion() {
		System.out.println("getConnetcion");
		Connection getConnetcion = (Connection) jdbc.getConnection();
		return getConnetcion;
	}

}
