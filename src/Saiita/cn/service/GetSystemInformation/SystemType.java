package Saiita.cn.service.GetSystemInformation;

import java.util.Properties;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
/**
 * �ж�ϵͳ����
 * Windos
 * Linux
 * @author Cheng
 *
 */

public class SystemType {
	public static Log logger = LogFactory.getLog(SystemType.class);

	public String JudgmentSystemType() {
		// �жϲ���ϵͳ��Windows ���� Liunx
		Properties prop = System.getProperties();
		String os = prop.getProperty("os.name");
		if (os != null && os.toLowerCase().indexOf("linux") > -1) {
			logger.info("Ubuntu");
			return "Ubuntu";
		} else {
			logger.info("Windows");
			return "Windows";
		}
	}
}
