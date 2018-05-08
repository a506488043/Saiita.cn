package Saiita.cn.service.GetSystemInformation;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class createFile {
	public static Log logger = LogFactory.getLog(createFile.class);

	public ObjectInputStream createRSAFile(String path) throws IOException {
		// 判断操作系统是Windows 还是 Liunx
		FileInputStream fis;
		SystemType systemType = new SystemType();
		String osName = systemType.JudgmentSystemType();
		if (osName.equals("Ubuntu")) {
			fis = new FileInputStream(path);
		} else {
			fis = new FileInputStream(path);
		}
		ObjectInputStream oos = new ObjectInputStream(fis);
		fis.close();
		return oos;
	}
}
