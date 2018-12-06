package Saiita.cn.JDBC;

import com.mysql.jdbc.Connection;

public class getConnetcion {
	static JDBC jdbc = new JDBC();

	public Connection Connetcion() {
		Connection getConnetcion = (Connection) jdbc.getConnection();
		return getConnetcion;
	}
public static void main(String[] args) {
	Connection getConnetcion = (Connection) jdbc.getConnection();
}
}
