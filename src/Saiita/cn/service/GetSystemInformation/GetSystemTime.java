package Saiita.cn.service.GetSystemInformation;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
/**
 * 添加获取系统时间
 */
public class GetSystemTime {
	public static Log logger = LogFactory.getLog(GetSystemTime.class);
	public String GetSystemTime() {
		logger.info("获取系统时间，格式：yyyy-MM-dd HH:mm:ss");
		// 获取系统时间，设置日期格式
		long l = System.currentTimeMillis();
		Date date = new Date(l);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return sdf.format(date);
	}

	public long GetSyetemTimes() {
		logger.info("获取系统时间");
		return System.currentTimeMillis();
	}

}
