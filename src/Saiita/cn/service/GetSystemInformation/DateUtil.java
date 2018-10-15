package Saiita.cn.service.GetSystemInformation;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateUtil {

	public static int getDaysOfMonth(Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		return calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
	}

	public static void main(String[] args) throws ParseException {
		//获取每月的天数
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		GetSystemTime time =new GetSystemTime();
		DateUtil getDays =new DateUtil();
		int days=DateUtil.getDaysOfMonth(sdf.parse(time.GetSystemTime1()));
		System.out.println("天数");
	}
}
