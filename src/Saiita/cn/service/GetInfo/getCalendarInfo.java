package Saiita.cn.service.GetInfo;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.mysql.jdbc.Connection;

import Saiita.cn.JDBC.JDBC;
import Saiita.cn.entity.calendar;
import Saiita.cn.service.GetInfo.Log.LogRecord;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class getCalendarInfo {
	static JDBC jdbc = new JDBC();
	public static Log logger = LogFactory.getLog(getCalendarInfo.class);
	LogRecord log = new LogRecord();
	public static List<calendar> getCalendar() throws SQLException{
		//连接数据库		
		Connection getConnetcion = (Connection) jdbc.getConnection();
		//MySQL:查询calendar表
		String sql="SELECT*FROM calendar";
		
		PreparedStatement pstmt;
		
		List<calendar> list = new ArrayList<calendar>();
		
		pstmt = getConnetcion.prepareStatement(sql);
		
		ResultSet rs = pstmt.executeQuery();
		while (rs.next()) {
			calendar calendar = new calendar();
			// 总支出金额
			calendar.setId(rs.getInt("id"));
			calendar.setDraggableEvents(rs.getString("DraggableEvents"));
			calendar.setTitle(rs.getString("title"));
			calendar.setStart(rs.getString("start"));
			calendar.setEnd(rs.getString("end"));
			calendar.setBackgroundColor(rs.getString("backgroundColor"));
			calendar.setBorderColor(rs.getString("borderColor"));
			calendar.setAllDay(rs.getString("allDay"));
			list.add(calendar);
		}
		pstmt.close();
		getConnetcion.close();
		return list;
		
	}
	
}
