package Saiita.cn.service.GetInfo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.Connection;

import Saiita.cn.JDBC.RedmineJDBC;
import Saiita.cn.entity.RedmineBugs;

/**
 * 
 * @author www.saiita.cn 获取Python统计的数据。
 */
public class getRedmineBug {
	static RedmineJDBC jdbc = new RedmineJDBC();
	static Connection getConnetcion = (Connection) jdbc.getConnection();
	static String sql = "";

	public static void main(String[] args) throws SQLException {
		List<RedmineBugs> list = getRedmineBug.getDaysInfo();
		for (int i = 0; i < list.size(); i++) {
			RedmineBugs info = (RedmineBugs) list.get(i);
			System.out.println(info.getDays());
			System.out.println(info.getTimes());
		}
	}

	public static List<RedmineBugs> getBugsInfo() throws SQLException {
		sql = "SELECT*FROM Bugs";
		PreparedStatement pstmt;
		List<RedmineBugs> bug = new ArrayList<RedmineBugs>();
		pstmt = getConnetcion.prepareStatement(sql);
		ResultSet rs = pstmt.executeQuery();
		while (rs.next()) {
			RedmineBugs info = new RedmineBugs();
			info.getId();
			info.getProject();
			info.getStatus();
			info.getPriority();
			info.getTracker();
			info.getAuthor();
			info.getSubject();
			info.getDescription();
			info.getDone_ratio();
			info.getStart_date();
			info.getDone_ratio();
			bug.add(info);
		}
		pstmt.close();
		getConnetcion.close();
		return bug;
	}

	public static List<RedmineBugs> getDaysInfo() throws SQLException {
		sql = "SELECT*FROM The_BUG_days_report";
		PreparedStatement pstmt;
		List<RedmineBugs> bug = new ArrayList<RedmineBugs>();
		pstmt = getConnetcion.prepareStatement(sql);
		ResultSet rs;
		try {
			rs = pstmt.executeQuery();
			while (rs.next()) {
				RedmineBugs info = new RedmineBugs();
				info.setDays(rs.getString("days"));
				info.setTimes(rs.getString("times"));;
				bug.add(info);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			pstmt.close();
			getConnetcion.close();
		}
		pstmt.close();
		getConnetcion.close();
		return bug;
	}

	public static List<RedmineBugs> getWeeksInfo() throws SQLException {
		sql = "The_BUG_weeks_report";
		PreparedStatement pstmt;
		List<RedmineBugs> bug = new ArrayList<RedmineBugs>();
		pstmt = getConnetcion.prepareStatement(sql);
		ResultSet rs = pstmt.executeQuery();
		while (rs.next()) {
			RedmineBugs info = new RedmineBugs();
			info.getWeek();
			info.getTimes();
			bug.add(info);
		}
		pstmt.close();
		getConnetcion.close();
		return bug;
	}

	public static List<RedmineBugs> getMonthsInfo() throws SQLException {
		sql = "The_BUG_month_report";
		PreparedStatement pstmt;
		List<RedmineBugs> bug = new ArrayList<RedmineBugs>();
		pstmt = getConnetcion.prepareStatement(sql);
		ResultSet rs = pstmt.executeQuery();
		while (rs.next()) {
			RedmineBugs info = new RedmineBugs();
			info.getMonth();
			info.getTimes();
			bug.add(info);

		}
		pstmt.close();
		getConnetcion.close();
		return bug;
	}

	public static List<RedmineBugs> getYearsInfo() throws SQLException {
		sql = "The_BUG_year_report";
		PreparedStatement pstmt;
		List<RedmineBugs> bug = new ArrayList<RedmineBugs>();
		pstmt = getConnetcion.prepareStatement(sql);
		ResultSet rs = pstmt.executeQuery();
		while (rs.next()) {
			RedmineBugs info = new RedmineBugs();
			info.getYears();
			info.getYears();
			bug.add(info);
		}
		pstmt.close();
		getConnetcion.close();
		return bug;
	}

}
