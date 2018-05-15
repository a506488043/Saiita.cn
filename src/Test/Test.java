package Test;

import java.util.List;

import Saiita.cn.entity.SafeLog;
import Saiita.cn.service.GetInfo.getSafetyLog;

public class Test {
	public static void main(String[] args) throws Exception {

		List<SafeLog> list = getSafetyLog.getLogInfo(7);
		System.out.println();
	}
}
