package Saiita.cn.service.GetSystemInformation;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
/**
 * ��ӻ�ȡϵͳʱ��
 */
public class GetSystemTime {
	public static Log logger = LogFactory.getLog(GetSystemTime.class);
	public String GetSystemTime() {
		logger.info("��ȡϵͳʱ�䣬��ʽ��yyyy-MM-dd HH:mm:ss");
		// ��ȡϵͳʱ�䣬�������ڸ�ʽ
		long l = System.currentTimeMillis();
		Date date = new Date(l);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return sdf.format(date);
	}

	public static long GetSyetemTimes() {
		logger.info("��ȡϵͳʱ��");
		return System.currentTimeMillis();
	}
	
	public static String GetSystemTime1() {
		logger.info("��ȡϵͳʱ�䣬��ʽ��yyyy-MM-dd HH:mm:ss");
		// ��ȡϵͳʱ�䣬�������ڸ�ʽ
		long l = System.currentTimeMillis();
		Date date = new Date(l);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		return sdf.format(date);
	}
	public static void main(String[] args) {
		String time=GetSystemTime1();
		System.out.println(time);
	}

}
