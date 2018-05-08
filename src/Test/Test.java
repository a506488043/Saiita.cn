package Test;

import java.util.List;
import java.util.regex.Pattern;

import Saiita.cn.entity.alipayInfo;
import Saiita.cn.service.GetInfo.getAllAlpayInfo;
import net.sf.json.JSONArray;

public class Test {
	public static void main(String[] args) throws Exception {
//		String content = "123 ";
//		String pattern = "<script>(.*?)</script>";
//		boolean isMatch = Pattern.matches(pattern, content);
//		System.out.println(isMatch);

		String[] value = { "root", "61810cyc<script>alert(1)</script>" };
		String[] scriptPattern = { "", "onload(.*?)=", "<script>(.*?)</script>",
				"src[\\r\\n]*=[\\r\\n]*\\\\\\'(.*?)\\\\\\'", "src[\\r\\n]*=[\\r\\n]*\\\\\\\"(.*?)\\\\\\\"", "</script>",
				"<script(.*?)>", "eval\\\\((.*?)\\\\)", "e­xpression\\\\((.*?)\\\\)", "javascript:", "vbscript:" };
		System.out.println(scriptPattern.length);
		for (int i = 0; i < value.length; i++) {
			for (int j = 0; j < scriptPattern.length; j++) {
				System.out.println(Pattern.matches(scriptPattern[j], value[i]));
			}
		}
		// List<alipayInfo> list = getAllAlpayInfo.getAllAlpayInfo();
		// String jsonDocumentList = JSONArray.fromObject(list).toString();
		// System.out.println(jsonDocumentList);
		// String a="Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36
		// (KHTML, like Gecko) Chrome/67.0.3371.0 Safari/537.36";
		// System.out.println(a.length());

		// Properties prop = System.getProperties();
		// String os = prop.getProperty("os.name");
		// if (os != null && os.toLowerCase().indexOf("linux") > -1) {
		// System.out.println("1");
		// } else {
		// System.out.println("2");
		// }

	}
}
